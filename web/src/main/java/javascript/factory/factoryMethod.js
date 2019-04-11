var ThirtAnimal = {
    create(type) {
        var animal = Object.create(ThirtAnimal.prototype);
        animal.type = type;
        return animal;
    },
    isAnimal(obj, type) {
        if (!ThirtAnimal.prototype.isPrototypeOf(obj)) {
            return false;
        }
        return type ? obj.type === type : true;
    },
    prototype: {}
};

var Peg = {
    create(name, breed) {
        var proto = Object.assign(ThirtAnimal.create("dog"), Peg.prototype);
        var dog = Object.create(proto);
        dog.name = name;
        dog.breed = breed;
        return dog;
    },
    isPeg(obj) {
        return ThirtAnimal.isAnimal(obj, "dog");
    },
    prototype: {
        bark() {
            console.log("ruff, ruff");
        },
        print() {
            console.log("The peg " + this.name + " is a " + this.breed);
        }
    }
};
var sparkie = Peg.create("Sparkie", "Border Collie");

sparkie.name;    // "Sparkie"
sparkie.breed;   // "Border Collie"
sparkie.bark();  // console: "ruff, ruff"
sparkie.print(); // console: "The dog Sparkie is a Border Collie"

Peg.isPeg(sparkie); // true