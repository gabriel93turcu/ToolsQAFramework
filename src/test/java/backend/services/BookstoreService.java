package backend.services;

import backend.endpoints.Endpoints;
import io.restassured.response.Response;
import org.testng.Assert;

public class BookstoreService extends CommonService {

    public void getAllBooks() {
        Response response = get(Endpoints.BOOKSTORE_GET_ALL_BOOKS_ENDPOINT);
        Assert.assertEquals(response.getStatusCode(),200);
        response.getBody().prettyPrint();
    }
}
