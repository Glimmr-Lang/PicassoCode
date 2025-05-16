# Module

module Color – A module for creating and working with RGBA color values.

# Functions

`function new_a(r=255, g=255, b=255, a=255)`

- `function new_a(r=255, g=255, b=255, a=255)` – Creates a new color with red, green, blue, and alpha components using `pic_nat_createcolora`.

- **r** – Red channel value (0–255).
    
- **g** – Green channel value (0–255).
    
- **b** – Blue channel value (0–255).
    
- **a** – Alpha (transparency) channel value (0–255).

`function new(r=255, g=255, b=255)`

- **function new(r=255, g=255, b=255)** – Creates a new opaque color (alpha = 255) using `pic_nat_createcolora`.

- **r** – Red channel value (0–255).
    
- **g** – Green channel value (0–255).
    
- **b** – Blue channel value (0–255).
    

# Variables

`let RED = pic_nat_createcolora(255, 0, 0, 255)`

- A predefined red color.
- Can be accessed by color.RED.
    

`let GREEN = pic_nat_createcolora(0, 255, 0, 255)`

- A predefined green color.
- Can be accessed by color.GREEN.

`let BLUE = pic_nat_createcolora(0, 0, 255, 255)`

- A predefined blue color.
- Can be accessed by color.BLUE.

