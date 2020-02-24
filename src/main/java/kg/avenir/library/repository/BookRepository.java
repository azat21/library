package kg.avenir.library.repository;

import kg.avenir.library.entity.Author;
import kg.avenir.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>, QuerydslPredicateExecutor<Book> {
    List<Book> findAllByAuthor(Author author);
    List<Book> findAllByNameContainsIgnoreCase(String searchString);


}
