package tasks.exceptions.utility;

import java.util.logging.Logger;

public class Square {
    private double width;
    private double height;
    private static final Logger log = Logger.getLogger(Square.class.getName());

    public void setHeight(double height) throws InvalidArgumentException {
        if (height<=0)
        {
            log.info("InvalidArgument");
            throw new InvalidArgumentException("width is incorrect");
        }
        this.height = height;
    }

    public void setWidth(double width) throws InvalidArgumentException {
        if(width<=0) {
            log.info("InvalidArgument");
            throw new InvalidArgumentException("width is incorrect");
        }
        this.width = width;
    }
    public String getSquare()
    {
        return String.valueOf(width*height);
    }
}
