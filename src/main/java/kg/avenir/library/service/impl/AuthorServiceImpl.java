package kg.avenir.library.service.impl;

import com.querydsl.core.BooleanBuilder;
import kg.avenir.library.dto.author.AuthorDto;
import kg.avenir.library.dto.book.BookIdsDto;
import kg.avenir.library.entity.Author;
import kg.avenir.library.entity.Book;
import kg.avenir.library.entity.QAuthor;
import kg.avenir.library.filterRequest.author.AuthorFilterRequest;
import kg.avenir.library.mapper.AuthorMapper;
import kg.avenir.library.repository.AuthorRepository;
import kg.avenir.library.service.AuthorService;
import kg.avenir.library.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;


@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final BookService bookService;
    private final AuthorMapper authorMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository, BookService bookService, AuthorMapper authorMapper) {
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
    public List<Author> findAll() {
        List<Author> authors = authorRepository.findAll();
        List<Author> dtos = new ArrayList<>();
        for (Author author : authors) {
            List<Book> booksByAuthor = bookService.getBooksByAuthor(author);
            AuthorDto authorDto = authorMapper.toAuthorDto(author, booksByAuthor);
            dtos.add(author);
        }
        return dtos;
    }

    @Override
    public Page<AuthorDto> search(AuthorFilterRequest filterRequest) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (filterRequest.getSearchRequest().getSearchString() != null) {
            predicate.andAnyOf(QAuthor.author.firstName.containsIgnoreCase(
                    filterRequest.getSearchRequest().getSearchString()),
                    QAuthor.author.lastName.containsIgnoreCase(
                            filterRequest.getSearchRequest().getSearchString())
            );
        }

        if (filterRequest.getSearchRequest().getBirthDateMin() != null) {
            predicate.and(QAuthor.author.birthDate.after(
                    filterRequest.getSearchRequest().getBirthDateMin()
            ));
        }

        if (filterRequest.getSearchRequest().getBirthDateMax() != null) {
            predicate.and(QAuthor.author.birthDate.before(
                    filterRequest.getSearchRequest().getBirthDateMax()
            ));
        }

        Integer size = filterRequest.getPageRequest().getPageSize();
        Integer pageNumber = filterRequest.getPageRequest().getPageNumber();
        PageRequest page = PageRequest.of(pageNumber, size);

        return authorRepository.findAll(predicate, page)
                .map(x -> authorMapper.toAuthorDto(x, bookService.getBooksByAuthor(x)));
    }

    @Override
    public Author getById(Long id) {
        return authorRepository.getOne(id);
    }
}