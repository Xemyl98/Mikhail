package factory;

import java.util.Date;

public class DigitalWatch implements Watch {
    @Override
    public String showTime() {
        return new Date().toString();
    }
}
