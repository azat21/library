package kg.avenir.library.endpoint.author.impl;

import kg.avenir.library.dto.author.AuthorDto;
import kg.avenir.library.dto.book.BookIdsDto;
import kg.avenir.library.endpoint.author.AuthorEndPoint;
import kg.avenir.library.entity.Author;
import kg.avenir.library.entity.Book;
import kg.avenir.library.filterRequest.author.AuthorFilterRequest;
import kg.avenir.library.mapper.AuthorMapper;
import kg.avenir.library.service.AuthorService;
import kg.avenir.library.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorEndPointImpl implements AuthorEndPoint {
    private final AuthorService authorService;
    private final AuthorMapper authorMapper;
    private final BookService bookService;

    public AuthorEndPointImpl(AuthorService authorService,
                              AuthorMapper authorMapper,
                              BookService bookService) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
        this.bookService = bookService;
    }

    @Override
    public List<AuthorDto> findAll() {
        return authorService.findAll().stream()
                .map(x-> authorMapper
                .toAuthorDto(x, bookService.getBooksByAuthor(x))).collect(Collectors.toList());

    }

    @Override
    public AuthorDto findById(Long id) {
        Author author = authorService.getById(id);
        List<Book> booksByAuthor = bookService.getBooksByAuthor(author);
        return authorMapper.toAuthorDto(author, booksByAuthor);
    }

    @Override
    public void bindBooksWithAuthor(Long id, BookIdsDto dto) {
        Author author = authorService.getById(id);
        bookService.findAllById(dto.getIds())
                .forEach(x -> bookService.updateAuthor(x, author));
    }

    @Override
    public Page<AuthorDto> search(AuthorFilterRequest filterRequest) {
        return authorService.search(filterRequest);
    }

}
