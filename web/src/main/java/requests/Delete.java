package requests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Delete {
    public static String getDeleteRequest(URL url) throws IOException {
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setDoOutput(true);
        httpCon.setRequestProperty(
                "Content-Type", "application/x-www-form-urlencoded");
        httpCon.setRequestMethod("DELETE");
        httpCon.connect();

        return httpCon.getResponseMessage();

    }
}
