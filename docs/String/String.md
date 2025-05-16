## Module String
- Module for working with strings.

## Module Functions

### `function format(fmt="", args=[])`
- Formats a string according to a specified format string and arguments.

###### Arguments
- `fmt` - The format string. Placeholders within this string will be replaced by the values in the `args` array. Defaults to an empty string (`""`). The syntax for the format string depends on the underlying implementation (`pic_nat_stringformat`).
- `args` - An array of arguments to be inserted into the format string. Defaults to an empty array (`[]`).

###### Returns
- The formatted string.

---

### `function trim(value="")`
- Removes whitespace from both ends of a string.

###### Arguments
- `value` - The string to trim. Defaults to an empty string (`""`).

###### Returns
- The string with leading and trailing whitespace removed.

---

### `function uppercase(value="")`
- Converts a string to uppercase.

###### Arguments
- `value` - The string to convert. Defaults to an empty string (`""`).

###### Returns
- The uppercase version of the input string.

---

### `function lowercase(value="")`
- Converts a string to lowercase.

###### Arguments
- `value` - The string to convert. Defaults to an empty string (`""`).

###### Returns
- The lowercase version of the input string.

---

### `function length(value="")`
- Returns the length of a string.

###### Arguments
- `value` - The string whose length is to be determined. Defaults to an empty string (`""`).

###### Returns
- The number of characters in the string.

---

### `function split(value="", delim="")`
- Splits a string into an array of substrings based on a specified delimiter.

###### Arguments
- `value` - The string to split. Defaults to an empty string (`""`).
- `delim` - The delimiter string used to split the `value`. Defaults to an empty string (`""`). If the delimiter is an empty string, the behavior might be implementation-specific 
  (e.g., splitting into individual characters).

###### Returns
- An array of strings that are substrings of the original string, separated by the delimiter.