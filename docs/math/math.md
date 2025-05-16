## Module Math
- Module providing common mathematical functions.

## Module Functions

### `function sin(a=0)`
- Calculates the sine of an angle.

###### Arguments
- `a` - An angle in radians. Defaults to `0`.

###### Returns
- The sine of the angle `a`.

---

### `function cos(a=0)`
- Calculates the cosine of an angle.

###### Arguments
- `a` - An angle in radians. Defaults to `0`.

###### Returns
- The cosine of the angle `a`.

---

### `function tan(a=0)`
- Calculates the tangent of an angle.

###### Arguments
- `a` - An angle in radians. Defaults to `0`.

###### Returns
- The tangent of the angle `a`.

---

### `function sinh(a=0)`
- Calculates the hyperbolic sine of a number.

###### Arguments
- `a` - A number. Defaults to `0`.

###### Returns
- The hyperbolic sine of `a`.

---

### `function cosh(a=0)`
- Calculates the hyperbolic cosine of a number.

###### Arguments
- `a` - A number. Defaults to `0`.

###### Returns
- The hyperbolic cosine of `a`.

---

### `function tanh(a=0)`
- Calculates the hyperbolic tangent of a number.

###### Arguments
- `a` - A number. Defaults to `0`.

###### Returns
- The hyperbolic tangent of `a`.

---

### `function asin(a=0)`
- Calculates the arcsine (inverse sine) of a number.

###### Arguments
- `a` - A number in the range [-1, 1]. Defaults to `0`.

###### Returns
- The arcsine of `a` in radians.

---

### `function acos(a=0)`
- Calculates the arccosine (inverse cosine) of a number.

###### Arguments
- `a` - A number in the range [-1, 1]. Defaults to `0`.

###### Returns
- The arccosine of `a` in radians.

---

### `function atan(a=0)`
- Calculates the arctangent (inverse tangent) of a number.

###### Arguments
- `a` - A number. Defaults to `0`.

###### Returns
- The arctangent of `a` in radians.

---

### `function abs(a=0)`
- Calculates the absolute value of a number.

###### Arguments
- `a` - A number. Defaults to `0`.

###### Returns
- The absolute value of `a`.

---

### `function floor(a=0)`
- Returns the largest integer less than or equal to a given number.

###### Arguments
- `a` - A number. Defaults to `0`.

###### Returns
- The floor of `a`.

---

### `function ceil(a=0)`
- Returns the smallest integer greater than or equal to a given number.

###### Arguments
- `a` - A number. Defaults to `0`.

###### Returns
- The ceiling of `a`.

---

### `function pow(a=0, b=0)`
- Returns the base `a` raised to the power of the exponent `b`.

###### Arguments
- `a` - The base number. Defaults to `0`.
- `b` - The exponent. Defaults to `0`.

###### Returns
- The result of `a` raised to the power of `b`.

---

### `function clamp(a=0, low=-1, high=1)`
- Constrains a number `a` to be within the range defined by `low` and `high`.

###### Arguments
- `a` - The number to clamp. Defaults to `0`.
- `low` - The lower bound of the range. Defaults to `-1`.
- `high` - The upper bound of the range. Defaults to `1`.

###### Returns
- The clamped value of `a`. If `a` is less than `low`, it returns `low`; if `a` is greater than `high`, it returns `high`; otherwise, it returns `a`.

---

### `function max(a=0, b=0)`
- Returns the larger of two numbers.

###### Arguments
- `a` - The first number. Defaults to `0`.
- `b` - The second number. Defaults to `0`.

###### Returns
- The larger value between `a` and `b`.

---

### `function min(a=0, b=0)`
- Returns the smaller of two numbers.

###### Arguments
- `a` - The first number. Defaults to `0`.
- `b` - The second number. Defaults to `0`.

###### Returns
- The smaller value between `a` and `b`.