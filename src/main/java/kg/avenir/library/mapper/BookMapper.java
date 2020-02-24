package kg.avenir.library.mapper;

import kg.avenir.library.dto.book.BookDto;
import kg.avenir.library.entity.Book;

public interface BookMapper {
    BookDto toDto(Book book);
}
