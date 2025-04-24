package tests.be;

import org.testng.annotations.Test;
import services.BookstoreService;

public class ObtainAllBooksTest {

    @Test
    public void testMethod() {
        BookstoreService bookstoreService = new BookstoreService();
        bookstoreService.getAllBooks();
    }
}
