package kg.avenir.library.filterRequest.book;

import kg.avenir.library.filterRequest.common.PageRequest;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BookFilterRequest {
    private PageRequest pageRequest;
    private BookSearchRequest searchRequest;

}
