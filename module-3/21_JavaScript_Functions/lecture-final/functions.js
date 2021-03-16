function sayHello() {
    console.log("Hello World");
}

/*
    Spread Operator
*/

function addWithSpread(x, y, z) {
    console.table(arguments);
    return x + y + z;
}

function demonstrateSpread() {
    const args = [1, 2, 3];
    console.log( addWithSpread(...args) );

    const argsLong = [1, 2, 3, 4, 5, 6, 7];
    console.log( addWithSpread(...argsLong) );

    const str = "Tech Elevator";
    console.log( addWithSpread(...str) );
}

/*
    Anonymous Functions
*/

// Assign them to a variable
const doubleSum = function ( x, y ) {
    return (x + y) * 2;
}

// assign the function to another variable
const anotherDoubleSum = doubleSum;

// can be passed as an argument to a function
function doMath(func) {
    console.log( func(1, 2))
}
doMath(doubleSum);

// Anonymous function using the fat arrow ( => ) operator
const trippleSum = (x, y) => {
    return (x + y) * 3;
}

// defines a function named name
//function name(x,y) {
    // function body
//}

// defines a function and stores it in a variable named name
//const name = function (x,y) {
    // function body
//}

// defines a function using the arrow operator and stores it in a variable
//const name = (x,y) => {
    // function body
//}

const arr = [1,2,3,4,5,6,7,8,9,10];

/*
  Array Function:  forEach()
*/
function demoForEach() {

    arr.forEach( (currentValue) => {
        console.log(currentValue);
    });
    
    // Is Equivalent to:
    for (let i = 0; i < arr.length; i++) {
        console.log( arr[i] );
    }

    let sum = 0;
    arr.forEach( (val) => {
        sum += val;
    });
    console.log( sum );

    const multipleByTwoFunc =   (val) => {
        console.log( val * 2 );
    }
    arr.forEach( multipleByTwoFunc );

}

/*
    Array: Reduce()
    1,2,3,4,5,6,7,8,9,10
*/
function demoArrayReduce() {

    reduce ( func, initialValue)

    const sum = arr.reduce( (ongoingSum, currentValue) => {
        return ongoingSum + currentValue;
    }, 0);

    console.log("Sum: " + sum);

    // The same thing in none functional code
    let ongoingSum = 0;
    for (let i = 0; i < arr.length; i++) {
        ongoingSum = ongoingSum + arr[i];
    }

    const stringArr = ["Steve", "John", "Matt", "Rachelle"];

    let finalString = stringArr.reduce( (ongoingValue, currentValue) => {
        const firstLetter = currentValue.substr(0,1);
        return ongoingValue + firstLetter;
    }, '');
    console.log(finalString);


}

/*
    Array Filter
    1,2,3,4,5,6,7,8,9,10
*/
function demoFilter() {

    // For each value in the array the anonymous
    // function will return TRUE or FALSE indicating
    // whether or not to add that value to the new array
    const filteredArray = arr.filter( (number) => {
        if (number % 3 == 0) {
            return false;
        }
        return true;
    });

    console.table(filteredArray);

}

/*
    Array Map
*/
function demoMap() {

    const mappedArray = arr.map( (value) => {
        return value * 2;
    })

    console.table(arr);
    console.table( mappedArray );
   
}

function fizzBuzz() {
    const fizzArr = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15];

    const finishedArr = fizzArr.map( val => {
        if ( !(val % 3) && !(val % 5)) {
            return "FizzBuzz";
        }
        if ( !(val % 3) ) {
            return 'Fizz';
        }
        if ( !(val % 5) ) {
            return 'Buzz';
        }
        return val;
    });

    console.table(finishedArr);
}


const nums = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15];
/*
    Find the sum of all numbers in the array, 
    multiplied by 10 for numbers that are not a multiple of 3
*/

console.table(nums);
// STEP 1: Filter the array so no multiples of 3
const filteredArray = nums.filter( num => {
    return num % 3;
});

console.table(filteredArray);

// STEP 2: Map the filtered Array to multiply everything by 10
const mappedArray = filteredArray.map( num => {
    return num * 10;
});

console.table(mappedArray);

// STEP 3: find the sum
const sum = mappedArray.reduce( (currentNumber, nextNumber) => {
    return currentNumber + nextNumber;
}, 0);

console.log("Result: " + sum);

// OR The same steps when chained together
const sumFromChain = nums.filter( num => {
                        return num % 3;
                    }).map( num => {
                        return num * 10;
                    }).reduce( (currentNumber, nextNumber) => {
                        return currentNumber + nextNumber;
                    }, 0);

console.log("Result from Chain: " + sumFromChain);


/*
  Using Anonymous Functions in our methods
  */
function doSomeMath(x, y, func) {
    return func(x, y);
}

console.log( doSomeMath(1, 3, (x, y) => { return x + y }  ));
console.log( doSomeMath(1, 3, (x, y) => { return x - y} ));
console.log( doSomeMath(1, 3, (x, y) => { return x * y} ));
console.log( doSomeMath(1, 3, (x, y) => { 
    const distance = Math.abs(x - y);
    const distancePowerOf3 = Math.pow(distance);
    return distancePowerOf3;
    } ));

function filterAndMap(filterFunc) {
    const sumFromChain = nums.filter( filterFunc )
                            .map( num => {
                                return num * 10;
                            }).reduce( (currentNumber, nextNumber) => {
                                return currentNumber + nextNumber;
                            }, 0);
    return sumFromChain;
}

console.log( filterAndMap ( val => { return val % 3 } ));
console.log( filterAndMap ( val => { return val % 5 } ));
console.log( filterAndMap ( val => { return !(val % 3) || !(val % 5) } ));
