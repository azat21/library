package kg.avenir.library.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.avenir.library.dto.author.AuthorDto;
import kg.avenir.library.dto.book.BookIdsDto;
import kg.avenir.library.endpoint.author.AuthorEndPoint;
import kg.avenir.library.filterRequest.author.AuthorFilterRequest;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(description = "Author-api", tags = {"Authors"})
@ApiOperation(value = "gets all authors")
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorEndPoint authorEndpoint;

    public AuthorController(AuthorEndPoint authorEndpoint) {
        this.authorEndpoint = authorEndpoint;
    }

    @GetMapping
    private List<AuthorDto> findAll() {
        return authorEndpoint.findAll();
    }

    @PostMapping("/{id}")
    private void bindBooksWithAuthor(@PathVariable Long id,
                                     @RequestBody BookIdsDto dto) {
        authorEndpoint.bindBooksWithAuthor(id, dto);
    }

    @PostMapping("/search")
    private Page<AuthorDto> search(@RequestBody AuthorFilterRequest filterRequest) {
        return authorEndpoint.search(filterRequest);
    }

    @GetMapping("/{id}")
    private AuthorDto getById(@PathVariable Long id) {
        return authorEndpoint.findById(id);
    }
}
