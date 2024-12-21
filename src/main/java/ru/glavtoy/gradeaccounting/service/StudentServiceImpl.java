package ru.glavtoy.gradeaccounting.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.glavtoy.gradeaccounting.dto.StudentDTO;
import ru.glavtoy.gradeaccounting.model.Student;
import ru.glavtoy.gradeaccounting.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            return StudentDTO.builder()
                    .firstname(student.getFirstname())
                    .lastname(student.getLastname())
                    .campus(student.getCampus()).build();
        }
        return StudentDTO.builder().build();
    }

    public List<StudentDTO> getAllStudents() {
        List<StudentDTO> studentDTOS = new ArrayList<>();
        studentRepository.findAll().forEach(student -> {
            studentDTOS.add(StudentDTO.builder()
                    .firstname(student.getFirstname())
                    .lastname(student.getLastname())
                    .campus(student.getCampus()).build());
        });
        return studentDTOS;
    }

    public StudentDTO addStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setFirstname(studentDTO.getFirstname());
        student.setLastname(studentDTO.getLastname());
        student.setCampus(studentDTO.getCampus());
        studentRepository.save(student);
        return studentDTO;
    }

    public Student deleteStudent(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            studentRepository.delete(student);
            return student;
        }
        return new Student();
    }
}
