package kg.avenir.library.endpoint.student.impl;

import kg.avenir.library.dto.book.BookIdsDto;
import kg.avenir.library.dto.student.StudentCreateDto;
import kg.avenir.library.dto.student.StudentDto;
import kg.avenir.library.dto.student.StudentUpdateDto;
import kg.avenir.library.endpoint.student.StudentEndPoint;
import kg.avenir.library.entity.Student;
import kg.avenir.library.mapper.StudentMapper;
import kg.avenir.library.service.BookService;
import kg.avenir.library.service.StudentService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentEndPointImpl implements StudentEndPoint {

    private final StudentService studentService;
    private final BookService bookService;
    private final StudentMapper studentMapper;

    public StudentEndPointImpl(StudentService studentService, BookService bookService, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.bookService = bookService;
        this.studentMapper = studentMapper;
    }


    @Override
    public List<StudentDto> findAll() {
        return studentService.findAll().stream()
                .map(studentMapper::toStudentDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto save(StudentCreateDto studentCreateDto) {
        Student student = studentMapper.toStudent(studentCreateDto);
        Student savedStudent = studentService.save(student);
        return studentMapper.toStudentDto(savedStudent);
    }

    @Override
    public StudentDto getById(Long id) {
        Student student = studentService.getById(id);
        return studentMapper.toStudentDto(student);
    }

    @Override
    public StudentDto update(Long id, StudentUpdateDto studentUpdateDto) {
        Student updatingStudent = studentService.getById(id);
        Student student = studentMapper.toStudent(updatingStudent, studentUpdateDto);
        Student updatedStudent = studentService.save(student);
        return studentMapper.toStudentDto(updatedStudent);
    }

    @Override
    public void bindBooksWithStudent(Long id, BookIdsDto dto) {
        Student student = studentService.getById(id);
        bookService.findAllById(dto.getIds())
                .forEach(x -> {
                    if (x.getQuantity() != 0) {
                        x.setQuantity(x.getQuantity() - 1);
                        bookService.updateStudent(x, student);
                    } else {
                        throw new EntityNotFoundException("Not enough Books with id " + x.getId());
                    }
                });
    }

    @Override
    public StudentDto addBook(Long id, BookIdsDto dto) {
        Student student = studentService.getById(id);
        return null;

    }

}
