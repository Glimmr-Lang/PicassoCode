import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.List;

public class SpriteSheetBuilder {

    private static final int ICON_SIZE = 16; // width and height of each icon
    private static final int ICONS_PER_ROW = 10; // sprite sheet grid width

    public static void main(String[] args) throws IOException {
        Path inputDir = Paths.get("icons"); // change to your icon folder
        Path outputImage = Paths.get("spritesheet.png");
        Path outputNames = Paths.get("icon_names.txt");

        // 1. Load and sort icon files
        List<Path> iconFiles = Files.list(inputDir)
            .filter(p -> p.toString().endsWith(".png"))
            .sorted()
            .toList();

        int iconCount = iconFiles.size();
        int rows = (int) Math.ceil((double) iconCount / ICONS_PER_ROW);

        // 2. Create a new sprite sheet image
        BufferedImage spriteSheet = new BufferedImage(
            ICONS_PER_ROW * ICON_SIZE,
            rows * ICON_SIZE,
            BufferedImage.TYPE_INT_ARGB
        );
        Graphics2D g = spriteSheet.createGraphics();

        // 3. Draw each icon into the sprite sheet
        List<String> names = new ArrayList<>();
        for (int i = 0; i < iconCount; i++) {
            Path iconPath = iconFiles.get(i);
            BufferedImage icon = ImageIO.read(iconPath.toFile());

            if (icon.getWidth() != ICON_SIZE || icon.getHeight() != ICON_SIZE) {
                System.out.println("Icon size must be 16x16: " + iconPath);
								continue;
            }

            int x = (i % ICONS_PER_ROW) * ICON_SIZE;
            int y = (i / ICONS_PER_ROW) * ICON_SIZE;
            g.drawImage(icon, x, y, null);

            String fileName = iconPath.getFileName().toString();
            String baseName = fileName.substring(0, fileName.lastIndexOf('.'));
            names.add(baseName);
        }

        g.dispose();

        // 4. Save the sprite sheet
        ImageIO.write(spriteSheet, "png", outputImage.toFile());

        // 5. Save the ordered names

				StringBuilder sb = new StringBuilder();
				sb.append("String[] icons = {\n");
				for (int i = 0; i < names.size(); i++) {
          sb.append(
					  String.format(
					   "\"%s\"%s", names.get(i), i < names.size() - 1 ? "," : ""
				    ).indent(4)
				  );
				}
				sb.append("};\n");

				
        Files.writeString(outputNames, sb.toString());

        System.out.println("✅ Sprite sheet generated: " + outputImage);
        System.out.println("📄 Icon names list: " + outputNames);
    }
}

