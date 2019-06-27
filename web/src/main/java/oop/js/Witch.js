var boiler = new Boiler();

$(function () {
    var classOfSelectedObject;

    $('.ingredient1').draggable({
        containment: $('.background'),
        start: function () {
            classOfSelectedObject = ".ingredient1";
        }
    });
    $('.ingredient2').draggable({
        containment: $('.background'),
        start: function () {
            classOfSelectedObject = ".ingredient2";
        }
    });
    $('.ingredient3').draggable({
        containment: $('.background'),
        start: function () {
            classOfSelectedObject = ".ingredient3";
        }
    });
    $('.ingredient4').draggable({
        containment: $('.background'),
        start: function () {
            classOfSelectedObject = ".ingredient4";
        }
    });
    $('.ingredient5').draggable({
        containment: $('.background'),
        start: function () {
            classOfSelectedObject = ".ingredient5";
        }
    });
    $('.ingredient6').draggable({
        containment: $('.background'),
        start: function () {
            classOfSelectedObject = ".ingredient6";
        }
    });
    $('.ingredient7').draggable({
        containment: $('.background'),
        start: function () {
            classOfSelectedObject = ".ingredient7";
        }
    });
    $('.ingredient8').draggable({
        containment: $('.background'),
        start: function () {
            classOfSelectedObject = ".ingredient8";
        }
    });
    $('.ingredient9').draggable({
        containment: $('.background'),
        start: function () {
            classOfSelectedObject = ".ingredient9";
        }
    });
    $('.boiler').droppable({
        drop: function () {
            if (boiler.setIngredientToBoiler(classOfSelectedObject)) {
                $(classOfSelectedObject).hide();
                $('.background').resize();
            }
        }
    });
    document.getElementById('mix').onclick = function () {
        boiler.brewPotion();
        $('.drink').show();
        $('.mix').hide();

    };
    document.getElementById('drink').onclick = function () {
        $('.drink').hide();
        $('.mix').hide();
        $('.reset').css({left: '47.5%'});
        for (var i = 1; i <= 9; i++)
            $('.boiler' + i).draggable("destroy");
        document.getElementById('witch').setAttribute('src', boiler.drinkPotion());

    };
    document.getElementById('reset').onclick = function () {
        location.reload();
    };
});



