package kg.avenir.library.mapper.impl;

import kg.avenir.library.dto.book.BookDto;
import kg.avenir.library.entity.Book;
import kg.avenir.library.mapper.AuthorMapper;
import kg.avenir.library.mapper.BookMapper;
import org.springframework.stereotype.Service;

@Service
public class BookMapperImpl implements BookMapper {

//            private final AuthorMapper authorMapper;
//
//    public BookMapperImpl(AuthorMapper authorMapper) {
//        this.authorMapper = authorMapper;
//    }

        @Override
        public BookDto toDto(Book book) {
            BookDto bookDto = new BookDto();
//        bookDto.setAuthor(authorMapper.toAuthorDto(book.getAuthor()));
            bookDto.setCategory(book.getCategory());
            bookDto.setName(book.getName());
            bookDto.setId(book.getId());
            bookDto.setQuantity(book.getQuantity());
            return bookDto;
        }

}
