package kg.avenir.library.service.impl;

import kg.avenir.library.dto.author.AuthorDto;
import kg.avenir.library.dto.book.BookIdsDto;
import kg.avenir.library.entity.Author;
import kg.avenir.library.entity.Book;
import kg.avenir.library.mapper.AuthorMapper;
import kg.avenir.library.repository.AuthorRepository;
import kg.avenir.library.service.AuthorService;
import kg.avenir.library.service.BookService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;


@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final BookService bookService;
    private final AuthorMapper authorMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository,
                             BookService bookService,
                             AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.bookService = bookService;
        this.authorMapper = authorMapper;
    }

    @Override
    public void bindBooksWithAuthor(Long id, BookIdsDto dto) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no Author with id " + id));
        List<Book> books = bookService.findAllById(dto.getIds());
        for (Book book : books) {
            bookService.updateAuthor(book, author);
        }
    }

    @Override
    public List<AuthorDto> findAll() {
        List<Author> authors = authorRepository.findAll();
        List<AuthorDto> dtos = new ArrayList<>();
        for (Author author : authors) {
            List<Book> booksByAuthor = bookService.getBooksByAuthor(author);
            AuthorDto authorDto = authorMapper.toAuthorDto(author, booksByAuthor);
            dtos.add(authorDto);
        }
        return dtos;

//        return authorRepository.findAll().stream()
//                .map(authorMapper::toAuthorDto)
//                .ma
//                .collect(Collectors.toList());
//    }
    }
}
