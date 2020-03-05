package kg.avenir.library.mapper;

import kg.avenir.library.dto.student.StudentCreateDto;
import kg.avenir.library.dto.student.StudentDto;
import kg.avenir.library.dto.student.StudentUpdateDto;
import kg.avenir.library.entity.Student;

public interface StudentMapper {
    StudentDto toStudentDto(Student student);
    Student toStudent(StudentCreateDto studentCreateDto);
    Student toStudent(Student updatingStudent, StudentUpdateDto studentUpdateDto);
}
