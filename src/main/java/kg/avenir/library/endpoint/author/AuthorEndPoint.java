package kg.avenir.library.endpoint.author;


import kg.avenir.library.dto.author.AuthorDto;
import kg.avenir.library.dto.book.BookIdsDto;
import kg.avenir.library.entity.Author;
import kg.avenir.library.filterRequest.author.AuthorFilterRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AuthorEndPoint {
    List<AuthorDto> findAll();
    AuthorDto findById(Long id);
    void bindBooksWithAuthor(Long id, BookIdsDto dto);
    Page<AuthorDto> search(AuthorFilterRequest filterRequest);


}
