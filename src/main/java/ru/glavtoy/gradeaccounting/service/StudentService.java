package ru.glavtoy.gradeaccounting.service;

import ru.glavtoy.gradeaccounting.dto.StudentDTO;
import ru.glavtoy.gradeaccounting.model.Student;

import java.util.List;

public interface StudentService {
    StudentDTO getStudentById(Long id);
    List<StudentDTO> getAllStudents();
    StudentDTO addStudent(StudentDTO studentDTO);
    Student deleteStudent(Long id);
}
