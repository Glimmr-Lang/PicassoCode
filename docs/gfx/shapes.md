-A module used to draw shapes.
# Function

`function drawLine(x1=0, y1=0, x2=1, y2=1)`

- **`function drawLine(x1=0, y1=0, x2=1, y2=1)`** – Draws a straight line from `(x1, y1)` to `(x2, y2)` using `pic_nat_drawline`.

- **x1, y1** – Starting coordinates of the line.

- **x2, y2** – Ending coordinates of the line.

---

`function drawRect(x=0, y=0, w=1, h=1)`

- **`function drawRect(x=0, y=0, w=1, h=1)`** – Draws a rectangle using `pic_nat_drawrect`.

- **x, y** – Top-left corner of the rectangle.

- **w, h** – Width and height of the rectangle.

---

`function drawRectA(pos=[0,0], size=[0,0])`

- **`function drawRectA(pos=[0,0], size=[0,0])`** – Draws a rectangle using vector-style arguments with `pic_nat_drawrect`.

- **pos** – A 2-element array specifying the rectangle's top-left corner `[x, y]`.

- **size** – A 2-element array specifying the rectangle's width and height `[w, h]`.

---

`function drawSquare(x=0, y=0, side=0)`

- **`function drawSquare(x=0, y=0, side=0)`** – Draws a square using `pic_nat_drawrect`.
- **x, y** – Top-left corner of the square.

- **side** – Length of the square's side.

---

`function drawSquareA(pos=[0,0], side=0)`

- **`function drawSquareA(pos=[0,0], side=0)`** – Draws a square using vector-style input with `pic_nat_drawrect`.

- **pos** – A 2-element array specifying the square's top-left corner `[x, y]`.

- **side** – Length of the square's side.

---

`function drawOval(x=0, y=0, w=1, h=1)`

- **`function drawOval(x=0, y=0, w=1, h=1)`** – Draws an oval inside the bounding box using `pic_nat_drawoval`.

- **x, y** – Top-left corner of the bounding box.

- **w, h** – Width and height of the bounding box.

---

`function drawString(str="", x=0, y=0)`

- **`function drawString(str="", x=0, y=0)`** – Renders text at the given coordinates using `pic_nat_drawstring`.

- **str** – The string to be drawn.

- **x, y** – Position where the string is drawn.

---

`function drawPolygon(xarr=[], yarr=[])`

- **`function drawPolygon(xarr=[], yarr=[])`** – Draws a closed polygon defined by the given vertex arrays using `pic_nat_drawpolygon`.

- **xarr** – Array of x-coordinates for the polygon’s vertices.

- **yarr** – Array of y-coordinates for the polygon’s vertices.

---

`function drawPolyline(xarr=[], yarr=[])`

- **`function drawPolyline(xarr=[], yarr=[])`** – Draws a connected series of lines (polyline) using `pic_nat_drawpolyline`.

- **xarr** – Array of x-coordinates for the polyline’s points.

- **yarr** – Array of y-coordinates for the polyline’s points.