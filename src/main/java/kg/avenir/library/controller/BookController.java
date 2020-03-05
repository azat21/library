package kg.avenir.library.controller;

import kg.avenir.library.dto.book.BookDto;
import kg.avenir.library.dto.book.UpdateBookQuantityDto;
import kg.avenir.library.endpoint.book.BookEndPoint;
import kg.avenir.library.entity.Book;
import kg.avenir.library.filterRequest.book.BookFilterRequest;
import kg.avenir.library.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/books")
public class BookController {


    private final BookEndPoint bookEndpoint;

    public BookController(BookEndPoint bookEndpoint) {
        this.bookEndpoint = bookEndpoint;
    }

    @GetMapping
    private List<BookDto> findAll() {
        return bookEndpoint.findAll();
    }

    @PutMapping("/{id}/updateQuantity")
    private void updateQuantity(@RequestBody @Validated UpdateBookQuantityDto dto,
                                @PathVariable Long id) {
        bookEndpoint.updateQuantity(id, dto);
    }

    @PostMapping("/search")
    private Page<BookDto> search(@RequestBody BookFilterRequest filterRequest) {
        return bookEndpoint.search(filterRequest);
    }


}
