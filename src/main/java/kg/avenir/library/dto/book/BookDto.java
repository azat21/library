package kg.avenir.library.dto.book;

import kg.avenir.library.dto.author.AuthorDto;
import kg.avenir.library.enums.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
    private Long id;
    private String name;
    private Category category;
    private AuthorDto author;
    private Integer quantity;
}
