package kg.avenir.library.service.impl;

import com.querydsl.core.BooleanBuilder;
import kg.avenir.library.dto.book.BookDto;
import kg.avenir.library.dto.book.UpdateBookQuantityDto;
import kg.avenir.library.entity.Author;
import kg.avenir.library.entity.Book;
import kg.avenir.library.entity.QBook;
import kg.avenir.library.entity.Student;
import kg.avenir.library.filterRequest.book.BookFilterRequest;
import kg.avenir.library.mapper.BookMapper;
import kg.avenir.library.repository.BookRepository;
import kg.avenir.library.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository,
                           BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }


    @Override
    public void updateQuantity(Long id, Integer quantity) {
        Book updatingBook = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no Book with id " + id));
        updatingBook.setQuantity(quantity);
        bookRepository.save(updatingBook);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findAllById(List<Long> ids) {
        return bookRepository.findAllById(ids);
    }

    @Override
    public Book updateAuthor(Book book, Author author) {
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getBooksByAuthor(Author author) {
        return bookRepository.findAllByAuthor(author);
    }

    @Override
    public Page<Book> search(BookFilterRequest filterRequest) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (filterRequest.getSearchRequest().getCategories() != null) {
            predicate.and(QBook.book.category.in(filterRequest.getSearchRequest().getCategories()));
        }

        if (filterRequest.getSearchRequest().getAuthorIds() != null) {
            predicate.and(QBook.book.author.id.in(filterRequest.getSearchRequest().getAuthorIds()));
        }

        if (filterRequest.getSearchRequest().getSearchString() != null &&
                !filterRequest.getSearchRequest().getSearchString().isBlank()) {
            predicate.and(QBook.book.name.containsIgnoreCase(filterRequest.getSearchRequest().getSearchString()));
        }

        Integer size = filterRequest.getPageRequest().getSize();
        Integer pageNumber = filterRequest.getPageRequest().getPageNumber();
        PageRequest page = PageRequest.of(pageNumber, size);

        return bookRepository.findAll(predicate, page);
    }

    @Override
    public Book updateStudent(Book book, Student student) {
        book.setStudent(student);
        return bookRepository.save(book);
    }
}
