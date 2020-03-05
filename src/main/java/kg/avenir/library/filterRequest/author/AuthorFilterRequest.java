package kg.avenir.library.filterRequest.author;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;

@Getter
@Setter
public class AuthorFilterRequest {
    private AuthorSearchRequest searchRequest;
    private PageRequest pageRequest;
}
