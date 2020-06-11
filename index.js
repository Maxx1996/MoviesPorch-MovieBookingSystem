console.log('Hello world');
let name = 'Mayank';
console.log(name);
let age = 23;
//object
let person = {
    name,
    age: null
};
console.log(person);
//Dot notation
person.name = 'Hemakshi';
console.log(person.name);
//bracket notation
person['name'] = 'Ashutosh';
console.log(person);
//runtime
let selection = 'name';
person[selection] = 'Aditya';
console.log(person.name)

//arrays
let selectedColors = ['Red', 'Blue'];
console.log(selectedColors);
selectedColors[0] = 'green';
console.log(selectedColors[0]);
console.log(selectedColors);
console.log(selectedColors[3]);
selectedColors[2] = 'white';
console.log(selectedColors);
selectedColors[3] = 1;
console.log(selectedColors.length);

//functions
function greet(name){
    console.log('Hello '+ name);
}
greet('Max');
greet(23);

function square(number){
    return number * number;
}

let number = square(6);
console.log(number);
//or
console.log(square(4));

//OOPS Concept
//procedural way 
let baseSalary = 30_000;
let overtime = 10;
let rate = 20;

function getWage(baseSalary, overtime, rate){
    return baseSalary + (overtime * rate);
}

console.log(getWage(baseSalary,overtime,rate));
//using object oriented
//oops Encapsulation
let employee = {
    baseSalary: 30_000,
    overtime: 10,
    rate: 20,
    getWage: function(){
        return this.baseSalary + (this.overtime * this.rate);
    }
};
console.log(employee.getWage());

//object literals = key, value pairs
const circle = {
    radius: 1,
    location: {
        x: 1, 
        y: 1
    },
    draw: function(){
        console.log('draw');
    }
};
circle.draw();

//factory function
function createCircle(radius){
    return {
        radius,
        draw: function(){
            console.log('draw');
        }
    };
}
const factoryCircle = createCircle(1);
//console.log(factoryCircle.draw());
//console.log(factoryCircle.radius)
factoryCircle.draw();

//constructor function
function Circle(radius){
    //console.log('this', this);
    this.radius = radius,
    this.draw = function(){
        console.log('draw');
    }
}
const constructorCircle = new Circle(10);
//Circle.call({}, 1); //alternate of line 108
//Circle.apply({}, [1, 2, 3]);//used to pass more than 1 argument

//primitive type {primitive are copied by their value}
let x = 10;
let y = x;
x = 20;
//x = 20, y = 10

//non primitive {object are copied by their reference}
let a = {value : 10};
let b = a;
a.value = 20;
// a = {value: 20}, b = {value: 20}

//primitive
let number1 = 10;
function increase(number1){
    number1++;
}
increase(number1);
console.log(number1);

//object
let obj = {value: 10};
function increase(obj){
    obj.value++;
}
increase(obj);
console.log(obj);

//adding properties to the Circle constructor
constructorCircle.location = {x: 1}; 
constructorCircle['location'] = {x: 1};//other way of line 141 or used when special character are used
delete constructorCircle.location; // to delete the property

//for in loop
for(let key in constructorCircle){
    console.log(key, constructorCircle[key]);//key represents -> all the key (including the property and members) 
                                             //constructorCircle[key] -> value of the keys
                                             
}

const keys = Object.keys(constructorCircle);//alternate way to display all the keys but we cannot seperate propety and members
console.log(keys);

for(let key in constructorCircle){
    if(typeof constructorCircle[key] !== 'function') //to display only the properties not members
    console.log(key, constructorCircle[key]);
}

if('radius' in constructorCircle)          //used to check for an existance of keys
    console.log('Circle has a radius.');

if('draw' in constructorCircle)             //work for method too
    console.log('Circle has a draw method.');

//Abstraction

function NewCircle(radius){
    this.radius = radius;
    let defaultLocation = {x: 0, y: 0}; // making it as a local variable, means not accessible from outside the function
    let computeOptimumLocation = function(factor){ // same as variable in line no 170
        //...
    }
    this.draw = function(){
        let x, y;                    //closure -> variable accessible to an inner function
        computeOptimumLocation(0.1); // we can access this method without {this} using closure 
        //defaultLocation
        //this.radius
        console.log('draw');
    };
}

const newCircle = new NewCircle(10);
//newCircle.computeOptimumLocation(0.1); //not accessible after making closure
newCircle.draw();

//Getter and Setter

function NewCircle1(radius){
    this.radius = radius;
    let defaultLocation = {x: 0, y: 0}; 

    this.getDefaultLocation = function(){ // getter for defaultLocation variable -> acting as a private variable
        return defaultLocation;
    };

    this.draw = function(){
        console.log('draw');
    };

    Object.defineProperty(this, 'defaultLocation',{
        get: function(){
            return defaultLocation;
        },
        set: function(value){
            if(!value.x || !value.y)                    //validation and error is builtin method takes string
                throw new Error('Invalid location.');
            defaultLocation = value;
        }
    });
}

const newCircle1 = new NewCircle1(15);
newCircle1.getDefaultLocation(); // because of getter we can call the getDefaultLocation
newCircle1.draw();