package kg.avenir.library.dto.book;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
public class BookSearchDto {
    @Min(3)
    private String searchString;
}
