package ru.glavtoy.gradeaccounting.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.glavtoy.gradeaccounting.dto.StudentDTO;
import ru.glavtoy.gradeaccounting.model.Student;
import ru.glavtoy.gradeaccounting.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @PostMapping("/add_student")
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO) {
        return new ResponseEntity<>(studentService.addStudent(studentDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete_student/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.deleteStudent(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }
}
