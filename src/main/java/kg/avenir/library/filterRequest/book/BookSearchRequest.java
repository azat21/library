package kg.avenir.library.filterRequest.book;


import kg.avenir.library.dto.author.AuthorDto;
import kg.avenir.library.entity.Author;
import kg.avenir.library.enums.Category;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class BookSearchRequest {
    @NotNull
    @NotBlank
    private String searchString;

    @NotEmpty
    private List<Long> authorIds;

    @NotEmpty
    private List<Category> categories;


}
