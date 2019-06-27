package requests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Get {
    public static String getRequest(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        return connection.getRequestMethod();
    }
}
