package services;

import client.RestClient;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import loggerUtility.LoggerUtility;
import modelObject.request.RequestCreateUser;

import java.util.Map;

public class CommonService {

    public Response post(Object requestBody, String endpoint) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.body(requestBody);
        LoggerUtility.requestLogs(requestSpecification, endpoint, "POST");

        return performRequest("POST", requestSpecification, endpoint);
    }

    public Response get(String endpoint) {
        RequestSpecification requestSpecification = RestAssured.given();

        LoggerUtility.requestLogs(requestSpecification, endpoint, "GET");
        return performRequest("GET", requestSpecification, endpoint);
    }

    public Response get(String endpoint, String token) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Authorization","Bearer " + token);
        return performRequest("GET", requestSpecification, endpoint);
    }

    public Response put(Map<String, String> requestBody, String endpoint) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.body(requestBody);
        return performRequest("PUT", requestSpecification, endpoint);
    }

    public Response delete(Map<String, String> requestBody, String endpoint) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.body(requestBody);
        return performRequest("DELETE", requestSpecification, endpoint);
    }

    public Response delete(String endpoint) {
        RequestSpecification requestSpecification = RestAssured.given();
        return performRequest("DELETE", requestSpecification, endpoint);
    }

    private Response performRequest(String requestType, RequestSpecification requestSpecification, String endpoint) {
        return new RestClient().performRequest(requestType, requestSpecification, endpoint);
    }
}
