class Boiler {
    constructor() {
        this.elixir = new Elixir();
        this.ingredients = new Ingredients();
        this.sumOfProperties = 0;
    }

    setIngredientToBoiler(nameOfIngredient) {
        return (this.ingredients.setIngredientToBoiler(nameOfIngredient));
    }

    brewPotion() {
        this.ingredients.clearIngredientsTable();
        this.sumOfProperties = 0;
        var ingredients = this.ingredients.getSelectedIngredientsValue();
        for (var i in ingredients)
            this.sumOfProperties += ingredients[i];
    }

    drinkPotion() {
        return (this.elixir.drink(this.sumOfProperties));
    }
}