package kg.avenir.library.service;

import kg.avenir.library.dto.author.AuthorDto;
import kg.avenir.library.dto.book.BookIdsDto;

import java.util.List;

public interface AuthorService {
    public void bindBooksWithAuthor(Long id, BookIdsDto dto);

    List<AuthorDto> findAll();
}
