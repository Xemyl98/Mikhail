function Animal(type) {
    this.type = type;
}

Animal.isAnimal = function (obj, type) {
    if (!Animal.prototype.isPrototypeOf(obj)) {
        return false;
    }
    return type ? obj.type === type : true;
};

function Peg(name, breed) {
    Animal.call(this, "dog");
    this.name = name;
    this.breed = breed;
}

Object.setPrototypeOf(Peg.prototype, Animal.prototype);
Peg.prototype.bark = function () {
    console.log("ruff, ruff");
};
Peg.prototype.print = function () {
    console.log("The dog " + this.name + " is a " + this.breed);
};

Peg.isDog = function (obj) {
    return Animal.isAnimal(obj, "dog");
};

var sparkie = new Peg("Sparkie", "Border Collie");
console.log(sparkie.name);    // "Sparkie"
console.log(sparkie.breed);   // "Border Collie"
sparkie.bark();  // console: "ruff, ruff"
sparkie.print(); // console: "The dog Sparkie is a Border Collie"
console.log(Peg.isDog(sparkie)); // true
