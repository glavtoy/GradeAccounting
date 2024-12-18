package ru.glavtoy.gradeaccounting.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.glavtoy.gradeaccounting.model.Student;
import ru.glavtoy.gradeaccounting.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @PostMapping("/add_student")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @DeleteMapping("/delete_student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Student>> getAllStudents() {
        return studentService.getAllStudents();
    }
}
