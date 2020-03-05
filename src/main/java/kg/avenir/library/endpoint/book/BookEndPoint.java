package kg.avenir.library.endpoint.book;

import kg.avenir.library.dto.book.BookDto;
import kg.avenir.library.dto.book.UpdateBookQuantityDto;
import kg.avenir.library.entity.Author;
import kg.avenir.library.entity.Book;
import kg.avenir.library.filterRequest.book.BookFilterRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookEndPoint {
    void updateQuantity(Long id, UpdateBookQuantityDto dto);
    List<BookDto> findAll();
    List<Book> findAllById(List<Long> ids);
    Page<BookDto> search(BookFilterRequest filterRequest);

}
