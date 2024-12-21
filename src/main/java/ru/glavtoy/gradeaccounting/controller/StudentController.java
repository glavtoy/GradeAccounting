package ru.glavtoy.gradeaccounting.controller;

import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(
            summary = "Добавляет студента в базу",
            description = "Принимает на вход данные студента (имя, фамилия, кампус) и добавляет в базу"
    )
    @PostMapping("/add_student")
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO) {
        return new ResponseEntity<>(studentService.addStudent(studentDTO), HttpStatus.OK);
    }

    @Operation(
            summary = "Удаляет студента из базы",
            description = "Принимает на вход ID студента и удаляет из базы"
    )
    @DeleteMapping("/delete_student/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.deleteStudent(id), HttpStatus.OK);
    }

    @Operation(
            summary = "Возвращает данные студента по ID",
            description = "Принимает на вход ID студента и возвращает его данные (имя, фамилия, кампус)"
    )
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @Operation(
            summary = "Возвращает данные всех студентов",
            description = "Возвращает полный список всех студентов (данные по каждому в виде: имя, фамилия, кампус)"
    )
    @GetMapping("/list")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }
}
