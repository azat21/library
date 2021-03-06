package kg.avenir.library.service;

import kg.avenir.library.dto.author.AuthorDto;
import kg.avenir.library.dto.book.BookIdsDto;
import kg.avenir.library.entity.Author;
import kg.avenir.library.filterRequest.author.AuthorFilterRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AuthorService {
    void bindBooksWithAuthor(Long id, BookIdsDto dto);

    List<Author> findAll();

    Page<AuthorDto> search(AuthorFilterRequest filterRequest);

    Author getById(Long id);


}
