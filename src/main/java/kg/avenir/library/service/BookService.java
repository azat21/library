package kg.avenir.library.service;

import kg.avenir.library.entity.Author;
import kg.avenir.library.entity.Book;
import kg.avenir.library.entity.Student;
import kg.avenir.library.filterRequest.book.BookFilterRequest;
import org.springframework.data.domain.Page;

import javax.transaction.Transactional;
import java.util.List;


public interface BookService {
    @Transactional
    void updateQuantity(Long id, Integer quantity);

    List<Book> findAll();
    List<Book> findAllById(List<Long> ids);
    Book updateAuthor(Book book, Author author);
    List<Book> getBooksByAuthor(Author author);
    Page<Book> search(BookFilterRequest filterRequest);

    Book updateStudent(Book book, Student student);
}
