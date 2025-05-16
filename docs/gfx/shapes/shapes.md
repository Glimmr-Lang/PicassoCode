### `function drawLine(x1=0, y1=0, x2=1, y2=1)`
- Draws a line segment between two points.

###### Arguments
- `x1` - The x-coordinate of the starting point of the line. Defaults to `0`.
- `y1` - The y-coordinate of the starting point of the line. Defaults to `0`.
- `x2` - The x-coordinate of the ending point of the line. Defaults to `1`.
- `y2` - The y-coordinate of the ending point of the line. Defaults to `1`.

###### Returns
- This function likely performs a drawing operation and may not explicitly return a value. The return type would depend on the underlying implementation (`pic_nat_drawline`). It might return a status code or nothing at all.

---

### `function drawRect(x=0, y=0, w=1, h=1)`
- Draws a rectangle.

###### Arguments
- `x` - The x-coordinate of the top-left corner of the rectangle. Defaults to `0`.
- `y` - The y-coordinate of the top-left corner of the rectangle. Defaults to `0`.
- `w` - The width of the rectangle. Defaults to `1`.
- `h` - The height of the rectangle. Defaults to `1`.

###### Returns
- This function likely performs a drawing operation and may not explicitly return a value. The return type would depend on the underlying implementation (`pic_nat_drawrect`). It might return a status code or nothing at all.

---

### `function drawRectA(pos=[0, 0], size=[0, 0])`
- Draws a rectangle using a position tuple/array and a size tuple/array.

###### Arguments
- `pos` - A tuple or array containing the x and y coordinates of the top-left corner of the rectangle. Defaults to `[0, 0]`.
    - `pos.0` - The x-coordinate.
    - `pos.1` - The y-coordinate.
- `size` - A tuple or array containing the width and height of the rectangle. Defaults to `[0, 0]`.
    - `size.0` - The width.
    - `size.1` - The height.

###### Returns
- This function likely performs a drawing operation and may not explicitly return a value. The return type would depend on the underlying implementation (`pic_nat_drawrect`). It might return a status code or nothing at all.

---

### `function drawSquare(x=0, y=0, side=0)`
- Draws a square.

###### Arguments
- `x` - The x-coordinate of the top-left corner of the square. Defaults to `0`.
- `y` - The y-coordinate of the top-left corner of the square. Defaults to `0`.
- `side` - The length of the side of the square. Defaults to `0`.

###### Returns
- This function likely performs a drawing operation and may not explicitly return a value. The return type would depend on the underlying implementation (`pic_nat_drawrect`). It might return a status code or nothing at all.

---

### `function drawSquareA(pos=[0, 0], side=0)`
- Draws a square using a position tuple/array and the side length.

###### Arguments
- `pos` - A tuple or array containing the x and y coordinates of the top-left corner of the square. Defaults to `[0, 0]`.
    - `pos.0` - The x-coordinate.
    - `pos.1` - The y-coordinate.
- `side` - The length of the side of the square. Defaults to `0`.

###### Returns
- This function likely performs a drawing operation and may not explicitly return a value. The return type would depend on the underlying implementation (`pic_nat_drawrect`). It might return a status code or nothing at all.

---

### `function drawOval(x=0, y=0, w=1, h=1)`
- Draws an oval (ellipse).

###### Arguments
- `x` - The x-coordinate of the top-left corner of the bounding box of the oval. Defaults to `0`.
- `y` - The y-coordinate of the top-left corner of the bounding box of the oval. Defaults to `0`.
- `w` - The width of the bounding box of the oval. Defaults to `1`.
- `h` - The height of the bounding box of the oval. Defaults to `1`.

###### Returns
- This function likely performs a drawing operation and may not explicitly return a value. The return type would depend on the underlying implementation (`pic_nat_drawoval`). It might return a status code or nothing at all.

---

### `function drawString(str="", x=0, y=0)`
- Draws a string of text.

###### Arguments
- `str` - The string to be drawn. Defaults to an empty string (`""`).
- `x` - The x-coordinate of the baseline of the text. Defaults to `0`.
- `y` - The y-coordinate of the baseline of the text. Defaults to `0`.

###### Returns
- This function likely performs a drawing operation and may not explicitly return a value. The return type would depend on the underlying implementation (`pic_nat_drawstring`). It might return a status code or nothing at all.

---

### `function drawPolygon(xarr=[], yarr=[])`
- Draws a polygon defined by arrays of x and y coordinates.

###### Arguments
- `xarr` - An array of x-coordinates of the polygon's vertices. Defaults to an empty array (`[]`).
- `yarr` - An array of y-coordinates of the polygon's vertices. Defaults to an empty array (`[]`). The number of elements in `xarr` and `yarr` should typically be the same.

###### Returns
- This function likely performs a drawing operation and may not explicitly return a value. The return type would depend on the underlying implementation (`pic_nat_drawpolygon`). It might return a status code or nothing at all.

---

### `function drawPolyline(xarr=[], yarr=[])`
- Draws a series of connected line segments defined by arrays of x and y coordinates.

###### Arguments
- `xarr` - An array of x-coordinates of the polyline's vertices. Defaults to an empty array (`[]`).
- `yarr` - An array of y-coordinates of the polyline's vertices. Defaults to an empty array (`[]`). The number of elements in `xarr` and `yarr` should typically be the same.

###### Returns
- This function likely performs a drawing operation and may not explicitly return a value. The return type would depend on the underlying implementation (`pic_nat_drawpolyline`). It might return a status code or nothing at all.