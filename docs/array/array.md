## Module Array
- Module for working with Arrays

## Module Functions 

`function concat(left=[], right=[])`
- A function for joining two arrays
###### Arguments
- left - The left side array
- right - The right side array

---
---

## Module Array
- Module for working with Arrays

## Module Functions

### `function concat(left=[], right=[])`
- A function for joining two arrays.

###### Arguments
- `left` - The left-side array. Defaults to an empty array (`[]`).
- `right` - The right-side array. Defaults to an empty array (`[]`).

###### Returns
- A new array containing all elements of `left` followed by all elements of `right`.

---

### `function toString(arr=[])`
- A function to convert an array to its string representation.

###### Arguments
- `arr` - The array to convert to a string. Defaults to an empty array (`[]`).

###### Returns
- A string representing the elements of the array, typically comma-separated. The exact format might depend on the underlying implementation (`pic_nat_array_tostring`).

---

### `function join(array=[], sep=",")`
- A function to join all elements of an array into a string, separated by a specified separator.

###### Arguments
- `array` - The array whose elements will be joined. Defaults to an empty array (`[]`).
- `sep` - The separator string to be used between elements. Defaults to a comma (`,`).

###### Returns
- A string formed by concatenating all elements of the array, separated by the `sep` string.
