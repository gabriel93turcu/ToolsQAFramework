package modelObject.backend.response;

import lombok.Getter;
import lombok.Setter;
import modelObject.models.BookModel;

import java.util.List;

@Getter
@Setter
public class ResponseCreateUser {
    private String userID;
    private String username;
    private List<BookModel> books;
}
