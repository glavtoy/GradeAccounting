package ru.glavtoy.gradeaccounting.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Контроллер студентов", description = "Управление студентами")
public class StudentController {

    private StudentService studentService;

    @Operation(
            summary = "Добавляет студента в базу",
            description = "Принимает на вход данные студента (имя, фамилия, кампус) и добавляет в базу"
    )
    @PostMapping("/add_student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Студент добавлен успешно"),
    })
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO) {
        return new ResponseEntity<>(studentService.addStudent(studentDTO), HttpStatus.OK);
    }

    @Operation(
            summary = "Удаляет студента из базы",
            description = "Принимает на вход ID студента и удаляет из базы"
    )
    @DeleteMapping("/delete_student/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Студент удалён успешно"),
            @ApiResponse(responseCode = "404", description = "Студент не существует")
    })
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
        Student student = studentService.deleteStudent(id);
        if (student.getId() != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
        return new ResponseEntity<>(student, HttpStatus.NOT_FOUND);
    }

    @Operation(
            summary = "Возвращает данные студента по ID",
            description = "Принимает на вход ID студента и возвращает его данные (имя, фамилия, кампус)"
    )
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Студент получен успешно"),
            @ApiResponse(responseCode = "404", description = "Студент не существует")
    })
    public ResponseEntity<StudentDTO> getStudent(@PathVariable Long id) {
        StudentDTO student = studentService.getStudentById(id);
        if (student.getCampus() != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
        return new ResponseEntity<>(student, HttpStatus.NOT_FOUND);
    }

    @Operation(
            summary = "Возвращает данные всех студентов",
            description = "Возвращает полный список всех студентов (данные по каждому в виде: имя, фамилия, кампус)"
    )
    @GetMapping("/list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список студентов получен успешно"),
    })
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }
}
