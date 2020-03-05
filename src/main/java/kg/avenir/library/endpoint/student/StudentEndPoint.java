package kg.avenir.library.endpoint.student;

import kg.avenir.library.dto.book.BookIdsDto;
import kg.avenir.library.dto.student.StudentCreateDto;
import kg.avenir.library.dto.student.StudentDto;
import kg.avenir.library.dto.student.StudentUpdateDto;
import kg.avenir.library.entity.Student;

import java.util.List;

public interface StudentEndPoint {
    List<StudentDto> findAll();

    StudentDto save(StudentCreateDto studentCreateDto);

    StudentDto getById(Long id);

    StudentDto update(Long id, StudentUpdateDto studentUpdateDto);

    void bindBooksWithStudent(Long id, BookIdsDto dto);

    StudentDto addBook(Long id, BookIdsDto dto);
}
