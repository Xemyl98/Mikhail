class NextAnimal {
    constructor(type) {
        this.type = type;
    }

    static isAnimal(obj, type) {
        if (!NextAnimal.prototype.isPrototypeOf(obj)) {
            return false;
        }
        return type ? obj.type === type : true;
    }
}

class Cat extends NextAnimal {
    constructor(name, breed) {
        super("dog");
        this.name = name;
        this.breed = breed;
    }

    bark() {
        console.log("ruff, ruff");
    }

    print() {
        console.log("The cat " + this.name + " is a " + this.breed);
    }

    static isCat(obj) {
        return NextAnimal.isAnimal(obj, "dog");
    }
}

var sparkie = new Cat("Sparkie2", "Border Collie2");
sparkie.name;
sparkie.breed;
sparkie.bark();
sparkie.print();
console.log(Cat.isCat(sparkie));