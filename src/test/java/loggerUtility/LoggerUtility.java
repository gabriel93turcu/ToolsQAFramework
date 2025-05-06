package loggerUtility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {
    private static final Logger logger = LogManager.getLogger();

    public static void startTest(String testName){
        logger.info("===== EXECUTION STARTED: " + testName + " =====");
    }

    public static void finishTest(String testName){
        logger.info("===== EXECUTION FINISHED: " + testName + " =====");
    }

    public static void infoLog(String message) {
        logger.info(message);
    }

    //pregatim loguri pentru request: url, method type, body
    public static void requestLogs(RequestSpecification requestSpecification, String path, String methodType) {
        infoLog("=== Request INFO ===");
        infoLog(getRequestURL(path));
        infoLog(getRequestMethod(methodType));
        infoLog(getRequestBody(requestSpecification));
    }

    private static String getRequestURL(String path){
        return "Request URI: https://demoqa.com"+path;
    }

    private static String getRequestMethod(String methodType){
        return "Request METHOD: "+methodType;
    }

    @SneakyThrows(JsonProcessingException.class)
    private static String getRequestBody(RequestSpecification requestSpecification) {
        String requestBodyMessage = "Request BODY: \n";

        Object requestBody = ((RequestSpecificationImpl) requestSpecification).getBody();
        if (requestBody != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            requestBodyMessage += objectMapper.readTree(requestBody.toString()).toPrettyString();
        }

        return requestBodyMessage;
    }

}
