package kg.avenir.library.mapper;

import kg.avenir.library.dto.author.AuthorDto;
import kg.avenir.library.entity.Author;
import kg.avenir.library.entity.Book;

import java.util.List;

public interface AuthorMapper {
    AuthorDto toAuthorDto(Author author, List<Book> books);
}
