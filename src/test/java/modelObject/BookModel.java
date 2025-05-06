package modelObject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookModel {
    private String isbn;
    private String title;
    private String subTitle;
    private String author;
    private String publish_date;
    private String publisher;
    private int pages;
    private String description;
    private String website;
}
