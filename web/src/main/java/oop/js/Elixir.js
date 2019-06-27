class Elixir {
    constructor() {
        this.path = "";
    }


    drink(sumOfProperties) {
        if (sumOfProperties > 4)
            this.path = '../../../resources/oop/goodElixir.png';
        else if (sumOfProperties >= 0)
            this.path = '../../../resources/oop/normElixir.png';
        else
            this.path = '../../../resources/oop/badElixir.png';
        return this.path;
    }
}