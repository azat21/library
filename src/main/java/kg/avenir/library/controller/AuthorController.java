package kg.avenir.library.controller;

import kg.avenir.library.dto.author.AuthorDto;
import kg.avenir.library.dto.book.BookIdsDto;
import kg.avenir.library.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    private List<AuthorDto> findAll() {
        return authorService.findAll();
    }

    @PostMapping("/{id}")
    private void bindBooksWithAuthor(@PathVariable Long id,
                                     @RequestBody BookIdsDto dto) {
        authorService.bindBooksWithAuthor(id, dto);
    }
}
