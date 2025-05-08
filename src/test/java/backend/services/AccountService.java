package backend.services;

import backend.endpoints.Endpoints;
import io.restassured.response.Response;
import modelObject.backend.request.RequestCreateUser;
import modelObject.backend.response.ResponseCreateUser;
import modelObject.backend.response.ResponseToken;
import org.testng.Assert;

public class AccountService extends CommonService {

    public ResponseCreateUser createAccount(RequestCreateUser requestBody) {
        Response response = post(requestBody, Endpoints.ACCOUNT_CREATE_USER_ENDPOINT);
        Assert.assertEquals(response.getStatusCode(), 201);
        return response.as(ResponseCreateUser.class);
    }

    public ResponseToken generateToken(RequestCreateUser requestBody) {
        Response response = post(requestBody, Endpoints.ACCOUNT_GENERATE_TOKEN_ENDPOINT);
        Assert.assertEquals(response.getStatusCode(), 200);
        return response.as(ResponseToken.class);
    }

    public void getSpecificAccount(String userID, String token){
        Response response = get(Endpoints.ACCOUNT_GET_USER_ENDPOINT+userID, token);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
