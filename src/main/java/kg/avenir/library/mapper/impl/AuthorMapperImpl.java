package kg.avenir.library.mapper.impl;

import kg.avenir.library.dto.author.AuthorDto;
import kg.avenir.library.dto.book.BookDto;
import kg.avenir.library.entity.Author;
import kg.avenir.library.entity.Book;
import kg.avenir.library.mapper.AuthorMapper;
import kg.avenir.library.mapper.BookMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorMapperImpl implements AuthorMapper {
    private final BookMapper bookMapper;

    public AuthorMapperImpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public AuthorDto toAuthorDto(Author author, List<Book> books) {
        List<BookDto> bookDtos = books.stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
        AuthorDto dto = new AuthorDto();
        dto.setBiography(author.getBiography());
        dto.setBirthDate(author.getBirthDate());
        dto.setDeathDate(author.getDeathDate());
        dto.setFirstName(author.getFirstName());
        dto.setLastName(author.getLastName());
        dto.setBooks(bookDtos);
        dto.setId(author.getId());
        return dto;
    }
}
