package tests.backend;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import backend.services.BookstoreService;
import sharedData.Hooks;

@Feature("FE-123")
@Story("ST-322")
public class ObtainAllBooksTest extends Hooks {

    @Test
    public void testMethod() {
        BookstoreService bookstoreService = new BookstoreService();
        bookstoreService.getAllBooks();
    }
}
