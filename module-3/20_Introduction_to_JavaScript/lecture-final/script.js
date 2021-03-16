const globalScope = "This variable is in global scope";

function scopes() {
  const functionScope = "This variable is in function scope";
  if (1 == 1) {
    const blockScope = "This variable is in block scope";
  }
}


console.log("JavaScript not in a function runs when loaded");
/*
    Example of a multi-line comment just like in C#/Java
*/

// Single line comment

/**
 * Functions start with the word function.
 * They don't have a return type and the naming convention is camel-case.
 */
function variables() {
  // Declares a variable where the value cannot be changed
  const daysPerWeek = 7;
  console.log(`There are ${daysPerWeek} days in the week`);
  // Declares a variable those value can be changed
  let daysPerMonth = 30;
  // Declares a variable that will always be an array
  const weekdays = [
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday"
  ];
  console.log(weekdays);
  console.table(weekdays);
}

/**
 * Functions can also accept parameters.
 * Notice the parameters do not have types.
 * @param {Number} param1 The first number to display
 * @param {Number} param2 The second number to display
 */
function printParameters(param1, param2) {
  console.log(`The value of param1 is ${param1}`);
  console.log(`The value of param2 is ${param2}`);
}

function typeOfVariable(param1) {
  if (typeof param1 == 'string') {
    console.log("Is a String");
  }
}

/**
 * Compares two values x and y.
 * == is loose equality
 * === is strict equality
 * @param {Object} x
 * @param {Object} y
 */
function equality(x, y) {
  console.log(`x is ${typeof x}`);
  console.log(`y is ${typeof y}`);

  console.log(`x == y : ${x == y}`); // true
  console.log(`x === y : ${x === y}`); // false
}

/**
 * Each value is inherently truthy or falsy.
 * false, 0, '', null, undefined, and NaN are always falsy
 * everything else is always truthy
 * @param {Object} x The object to check for truthy or falsy,
 */
function falsy(x) {
  if (x) {
    console.log(`${x} is truthy`);
  } else {
    console.log(`${x} is falsy`);
  }

  if (x) {
    console.log('x has a value');
  }
}

function arrays() {
  const numbers = [1, 2, 3, 4];
  console.table(numbers);
  console.log( numbers.length );
  // push will add to the end of an array
  numbers.push('abc');
  // unshift will add to the beginning of an array
  numbers.unshift('xyz');
  console.table(numbers);
  // pop will remove the last element of the array and return it
  console.log( numbers.pop() );

  console.log( numbers[2] );
  numbers[2] = 'zzz';
  console.table(numbers);

  numbers[10] = "this index doesn't exist";
  console.table(numbers);

  console.log( numbers[100] );
}


/**
 *  Objects are simple key-value pairs
    - values can be primitive data types
    - values can be arrays
    - or they can be functions
*/
function objects() {
  const person = {
    firstName: "Bill",
    lastName: "Lumbergh",
    age: 42,
    employees: [
      "Peter Gibbons",
      "Milton Waddams",
      "Samir Nagheenanajar",
      "Michael Bolton"
    ],
    toString: function() {
      return `${this.lastName}, ${this.firstName} (${this.age})`;
    }
  };

  // Log the object
  console.table(person);
  // Log the first and last name
  console.log( person.firstName + ' ' + person.lastName );

  // You can set the properties
  person.firstName = 'John';
  // If the property doesn't exist it is added
  person.lastname = 'Fulton';
  console.table(person);

  // Log each employee
  for (let i = 0; i < person.employees.length; i++) {
    console.log(`Employee ${i + 1} is ${person.employees[i]}`);
  }

  console.log( person.toString() );

  console.log( person.toString );

}

/*
########################
Function Overloading
########################

Function Overloading is not available in Javascript. If you declare a
function with the same name, more than one time in a script file, the
earlier ones are overriden and the most recent one will be used.
*/

function Add(num1, num2) {
  return num1 + num2;
}

function Add(num1, num2, num3) {
  return num1 + num2 + num3;
}

function dataConversion() {
  console.log( 1.5 + 5 );
  console.log( '1.5' + 5);
  console.log( parseFloat('1.5') + 5);
  console.log( Number('1.5') + 5);
  console.log( parseInt('1.5') + 5);
}

function isNotANumber() {
  console.log('1: ' +  isNaN(1) )
  console.log('"1": ' +  isNaN("1") )
  console.log('A: ' +  isNaN("A") )
  console.log('1/0: ' +  isNaN(1/0) )
  console.log('0/1: ' +  isNaN(0/1) )
  console.log('0/0: ' +  isNaN(0/0) )
}

/*
########################
Math Library
########################

A built-in `Math` object has properties and methods for mathematical constants and functions.
https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Math
*/

function mathFunctions() {
  console.log("Math.PI : " + Math.PI);
  console.log("Math.LOG10E : " + Math.LOG10E);
  console.log("Math.abs(-10) : " + Math.abs(-10));
  console.log("Math.floor(1.99) : " + Math.floor(1.99));
  console.log("Math.ceil(1.01) : " + Math.ceil(1.01));
  console.log("Math.random() : " + Math.random());
}

/*
########################
String Methods
########################

The string data type has a lot of properties and methods similar to strings in Java/C#
*/

function stringFunctions(value) {
  console.log(`.length -  ${value.length}`);
  console.log(`.endsWith('World') - ${value.endsWith("World")}`);
  console.log(`.startsWith('Hello') - ${value.startsWith("Hello")}`);
  console.log(`.indexOf('Hello') - ${value.indexOf("Hello")}`);

  console.log('substr(1,3): ' + value.substr(1, 3));
  console.log('substring(1,3): ' + value.substring(1, 3));

  /*
    Other Methods
        - split(string)
        - substr(number, number)
        - substring(number, number)
        - toLowerCase()
        - trim()
        - https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String
    */
}
