package tests.backend;

import org.testng.annotations.Test;
import backend.services.BookstoreService;
import sharedData.Hooks;

public class ObtainAllBooksTest extends Hooks {

    @Test
    public void testMethod() {
        BookstoreService bookstoreService = new BookstoreService();
        bookstoreService.getAllBooks();
    }
}
