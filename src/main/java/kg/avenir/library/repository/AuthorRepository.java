package kg.avenir.library.repository;

import kg.avenir.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
