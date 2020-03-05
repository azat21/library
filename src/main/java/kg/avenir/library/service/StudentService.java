package kg.avenir.library.service;

import kg.avenir.library.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    Student save(Student student);

    Student getById(Long id);
}
