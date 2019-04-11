function LastAnimal(type) {
    var animal = Object.create(LastAnimal.prototype);
    animal.type = type;
    return animal;
}

LastAnimal.isAnimal = function (obj, type) {
    if (!LastAnimal.prototype.isPrototypeOf(obj)) {
        return false;
    }
    return type ? obj.type === type : true;
};
LastAnimal.prototype = {};

function Mouse(name, breed) {
    var proto = Object.assign(LastAnimal("dog"), Mouse.prototype);
    var dog = Object.create(proto);
    dog.name = name;
    dog.breed = breed;
    return dog;
}

Mouse.isMouse = function (obj) {
    return LastAnimal.isAnimal(obj, "dog");
};
Mouse.prototype = {
    bark() {
        console.log("ruff, ruff");
    },
    print() {
        console.log("The mouse " + this.name + " is a " + this.breed);
    }
};
var sparkie = Mouse("Sparkie", "Border Collie");
sparkie.name;    // "Sparkie"
sparkie.breed;   // "Border Collie"
sparkie.bark();  // console: "ruff, ruff"
sparkie.print(); // console: "The dog Sparkie is a Border Collie"

Mouse.isMouse(sparkie); // true