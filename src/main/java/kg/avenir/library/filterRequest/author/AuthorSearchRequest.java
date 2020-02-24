package kg.avenir.library.filterRequest.author;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class AuthorSearchRequest {
    @NotNull
    @NotBlank
    private String searchRequest;
    @NotNull
    private LocalDate min;
    @NotNull
    private LocalDate max;
}
