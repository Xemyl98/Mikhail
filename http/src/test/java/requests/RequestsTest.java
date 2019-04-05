package requests;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class RequestsTest {
    private static URL getUrl;
    private static URL postUrl;
    private static URL deleteUrl;
    private static URL putUrl;

    @BeforeClass
    public static void beforeClass() throws MalformedURLException {
        getUrl = new URL("http://httpbin.org/ip");
        postUrl = new URL("https://selfsolve.apple.com/wcResults.do");
        deleteUrl = new URL("http://httpbin.org/delete");
        putUrl = new URL("http://httpbin.org/put");
    }

    @Test
    public void positiveGetTest() throws IOException {
        assertEquals("OK", Get.getRequest(getUrl));
    }

    @Test
    public void positivePostTest() throws IOException {
        assertEquals("OK", Post.getPostRequest(postUrl));
    }

    @Test
    public void positiveDeleteTest() throws IOException {
        assertEquals("OK", Delete.getDeleteRequest(deleteUrl));
    }

    @Test
    public void positivePutTest() throws IOException {
        assertEquals("OK", Put.getPutRequest(putUrl));
    }
}