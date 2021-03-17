

/**
 * This functions job, what can be expected from it,
 * but not why or how it does it. 
 * 
 * @param {string[] | number[]} param1 what this parameter represents
 * @param {number} param2 what this parameter represents
 * @return {Object[]} what output the function will have
 */
function doSomething(param1, param2) {

}


for (let i=0;...)  <-- standard for loop when not an array
for (val of array)  <-- standard foreach loop when an object (not an array)
array.forEach() <-- standard foreach for an array

array.reduce()  <-- reduces (aggregates) the array to a single value (like sum, average, min, max, etc)
array.map() <-- make the same change to all elements of the array
array.filter()  <-- removes items from the results and returns a copy of the array without them