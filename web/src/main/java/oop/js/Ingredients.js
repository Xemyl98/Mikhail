class Ingredients {
    constructor() {
        this.selectedIngredientsValue = [];
        this.ingedientsProperties = new Map();
        this.fillIngredientsProperties();
    }

    fillIngredientsProperties() {
        this.ingedientsProperties.set("Палец великана", -1);
        this.ingedientsProperties.set("Сердце даэдра", 3);
        this.ingedientsProperties.set("Куриное яйцо", 2);
        this.ingedientsProperties.set("Сладкий рулет", 5);
        this.ingedientsProperties.set("Желе нетча", -4);
        this.ingedientsProperties.set("Сердце изгоя", -3);
        this.ingedientsProperties.set("Яйцо нетча", -2);
        this.ingedientsProperties.set("Морозная соль", 2);
        this.ingedientsProperties.set("Ядовитые грибы", -5);
    }

    clearIngredientsTable() {
        for (var i = 1; i <= 3; i++) {
            document.getElementById('table' + i).setAttribute('src', "");
            document.getElementById('text' + i).innerText = "";
        }
    }

    setIngredientToBoiler(name) {
        name = name.substr(1, name.length);
        var parentImage = (document.getElementById(name));
        $('.drink').hide();
        $('.reset').css({left: '47.5%'});
        for (var i = 1; i <= 3; i++) {
            var childImage = document.getElementById('table' + i);
            if (childImage.getAttribute('src') === "") {
                var ingredientName = (document.getElementById('text' + i).innerText = parentImage.getAttribute('alt'));
                this.selectedIngredientsValue.push(this.ingedientsProperties.get(ingredientName));
                if (this.selectedIngredientsValue.length % 3 === 0) {
                    $('.mix').show();
                    $('.reset').css({left: '52%'});
                }
                childImage.setAttribute('src', parentImage.getAttribute('src'));
                return true;
            }
        }
        return false;
    }

    getSelectedIngredientsValue() {
        return (this.selectedIngredientsValue);
    }
}








