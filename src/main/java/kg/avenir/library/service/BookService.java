package kg.avenir.library.service;

import kg.avenir.library.dto.book.BookDto;
import kg.avenir.library.dto.book.UpdateBookQuantityDto;
import kg.avenir.library.entity.Author;
import kg.avenir.library.entity.Book;
import kg.avenir.library.filterRequest.book.BookFilterRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface BookService {
    void updateQuantity(Long id, UpdateBookQuantityDto dto);
    List<BookDto> findAll();
    List<Book> findAllById(List<Long> ids);
    Book updateAuthor(Book book, Author author);
    List<Book> getBooksByAuthor(Author author);
    Page<BookDto> search(BookFilterRequest filterRequest);
    Page<BookDto> searchAuthor (BookFilterRequest filterRequestForAuthor);
}
