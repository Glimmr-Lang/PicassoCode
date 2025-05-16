## Module Color
- Module for creating and working with color values.

## Module Functions

### `function new_a(r=255, g=255, b=255, a=255)`
- Creates a new color value with red, green, blue, and alpha components.

###### Arguments
- `r` - The red component of the color (0-255). Defaults to `255` (fully red).
- `g` - The green component of the color (0-255). Defaults to `255` (fully green).
- `b` - The blue component of the color (0-255). Defaults to `255` (fully blue).
- `a` - The alpha (opacity) component of the color (0-255). Defaults to `255` (fully opaque).

###### Returns
- A new color value represented by the underlying implementation (`pic_nat_createcolora`).

---

### `function new(r=255, g=255, b=255)`
- Creates a new fully opaque color value with red, green, and blue components. This is a convenience function that calls `new_a` with the alpha component set to 255.

###### Arguments
- `r` - The red component of the color (0-255). Defaults to `255`.
- `g` - The green component of the color (0-255). Defaults to `255`.
- `b` - The blue component of the color (0-255). Defaults to `255`.

###### Returns
- A new, fully opaque color value represented by the underlying implementation (`pic_nat_createcolora`).

## Module Constants

### `let RED`
- A predefined, fully opaque red color. It is created using `pic_nat_createcolora(255, 0, 0, 255)`.

### `let GREEN`
- A predefined, fully opaque green color. It is created using `pic_nat_createcolora(0, 255, 0, 255)`.

### `let BLUE`
- A predefined, fully opaque blue color. It is created using `pic_nat_createcolora(0, 0, 255, 255)`.