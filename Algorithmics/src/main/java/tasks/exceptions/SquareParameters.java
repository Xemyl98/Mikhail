package tasks.exceptions;

import tasks.exceptions.utility.InvalidArgumentException;
import tasks.exceptions.utility.Square;

public class SquareParameters {

    public String calculateSquare(double width, double height) throws InvalidArgumentException {
        Square square = new Square();
        square.setWidth(width);
        square.setHeight(height);
        return square.getSquare();
    }
}
