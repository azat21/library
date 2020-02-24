package kg.avenir.library.dto.author;

import kg.avenir.library.dto.book.BookDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class AuthorDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private String biography;
    private List<BookDto> books;
}
