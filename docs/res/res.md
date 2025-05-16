## Module Resources
- Module for loading and managing resources.

## Module Functions

### `function loadPaintResource(src="")`
- Loads a paint resource from the specified source.

###### Arguments
- `src` - The source or path to the paint resource. Defaults to an empty string (`""`). The type of this source (e.g., file path, URL) depends on the underlying implementation (`pic_nat_loadpaint`).

###### Returns
- A representation of the loaded paint resource. The exact type of the returned value is specific to the underlying implementation. It could be an object, a handle, or another data structure representing the paint resource.