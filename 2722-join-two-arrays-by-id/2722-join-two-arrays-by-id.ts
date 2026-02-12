type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };
type ArrayType = { "id": number } & Record<string, JSONValue>;

function join(arr1: ArrayType[], arr2: ArrayType[]): ArrayType[] {
    let map = {}; // also known as "hashmap"
    arr1.concat(arr2).forEach((item) => {
        if (map[item.id]) {
            Object.assign(map[item.id], item)
        }
        else {
            map[item.id] = item;
        }
    });

    return Object.values(map);
};