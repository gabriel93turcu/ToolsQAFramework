package tests.backend;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import modelObject.ModelPath;
import modelObject.backend.request.RequestCreateUser;
import modelObject.backend.response.ResponseCreateUser;
import modelObject.backend.response.ResponseToken;
import org.testng.annotations.Test;
import backend.services.AccountService;
import sharedData.Hooks;

@Feature("FE-123")
@Story("ST-321")
public class CreateUserBETest extends Hooks {

    @Test(description = "TC-ABC: Acesta este testul lui Gabi")
    public void testMethod() {
        AccountService accountService = new AccountService();

        System.out.println("=== STEP 1: CREATE USER ===");
        RequestCreateUser requestBody = new RequestCreateUser(ModelPath.REQUEST_CREATE_USER_PATH);
        ResponseCreateUser responseCreateUser = accountService.createAccount(requestBody);
        String userID = responseCreateUser.getUserID();
        System.out.println(userID);
        System.out.println();

        System.out.println("=== STEP 2: CREATE TOKEN FOR USER ===");
        ResponseToken responseToken = accountService.generateToken(requestBody);
        String token = responseToken.getToken();
        System.out.println(token);

        System.out.println("=== STEP 3: GET SPECIFIC USER ===");
        accountService.getSpecificAccount(userID,token);
    }
}
