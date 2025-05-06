package tests.be;

import org.testng.annotations.Test;
import services.BookstoreService;
import sharedData.SharedData;

public class ObtainAllBooksTest extends SharedData {

    @Test
    public void testMethod() {
        BookstoreService bookstoreService = new BookstoreService();
        bookstoreService.getAllBooks();
    }
}
