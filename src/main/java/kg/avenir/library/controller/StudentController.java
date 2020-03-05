package kg.avenir.library.controller;

import kg.avenir.library.dto.book.BookIdsDto;
import kg.avenir.library.dto.student.StudentCreateDto;
import kg.avenir.library.dto.student.StudentDto;
import kg.avenir.library.dto.student.StudentUpdateDto;
import kg.avenir.library.endpoint.student.StudentEndPoint;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentEndPoint studentEndpoint;

    public StudentController(StudentEndPoint studentEndPoint, StudentEndPoint studentEndpoint) {
        this.studentEndpoint = studentEndpoint;

    }

    @GetMapping
    private List<StudentDto> findAll() {
        return studentEndpoint.findAll();
    }

    @PostMapping
    private StudentDto save(@RequestBody StudentCreateDto studentCreateDto) {
        return studentEndpoint.save(studentCreateDto);
    }

    @GetMapping("/{id}")
    private StudentDto getById(@PathVariable Long id) {
        return studentEndpoint.getById(id);
    }

    @PutMapping("/{id}")
    private StudentDto update(@PathVariable Long id,
                              @RequestBody StudentUpdateDto studentUpdateDto) {
        return studentEndpoint.update(id, studentUpdateDto);
    }

    @PostMapping("/{id}")
    private void bindBooksWithStudent(@PathVariable Long id,
                                      @RequestBody BookIdsDto dto) {
        studentEndpoint.bindBooksWithStudent(id, dto);
    }
}
