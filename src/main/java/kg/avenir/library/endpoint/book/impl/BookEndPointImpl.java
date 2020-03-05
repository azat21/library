package kg.avenir.library.endpoint.book.impl;

import kg.avenir.library.dto.book.BookDto;
import kg.avenir.library.dto.book.UpdateBookQuantityDto;
import kg.avenir.library.endpoint.book.BookEndPoint;
import kg.avenir.library.entity.Book;
import kg.avenir.library.filterRequest.book.BookFilterRequest;
import kg.avenir.library.mapper.BookMapper;
import kg.avenir.library.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookEndPointImpl implements BookEndPoint {
    private final BookService bookService;
    private final BookMapper bookMapper;

    public BookEndPointImpl(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @Override
    public void updateQuantity(Long id, UpdateBookQuantityDto dto) {
        Integer quantity = dto.getQuantity();
        bookService.updateQuantity(id, quantity);
    }

    @Override
    public List<BookDto> findAll() {
        return bookService.findAll()
                .stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findAllById(List<Long> ids) {
        return bookService.findAllById(ids);
    }

    @Override
    public Page<BookDto> search(BookFilterRequest filterRequest) {
        return bookService.search(filterRequest)
                .map(bookMapper::toDto);
    }
}


