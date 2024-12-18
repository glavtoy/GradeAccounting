package ru.glavtoy.gradeaccounting.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.glavtoy.gradeaccounting.model.Grade;
import ru.glavtoy.gradeaccounting.service.StudentService;

@RestController
@RequestMapping("/api/grades")
@AllArgsConstructor
public class GradeController {

    private StudentService studentService;

    @PostMapping("/add_grade/{id}")
    public ResponseEntity<String> addGrade(@PathVariable Long id, @RequestBody Grade grade) {
        return studentService.addGrade(id, grade);
    }

    @DeleteMapping("/delete_grade/{id}")
    public ResponseEntity<String> addGrade(@PathVariable Long id) {
        return studentService.deleteGrade(id);
    }
}


