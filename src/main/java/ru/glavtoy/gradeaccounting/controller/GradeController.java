package ru.glavtoy.gradeaccounting.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.glavtoy.gradeaccounting.dto.GradeDTO;
import ru.glavtoy.gradeaccounting.model.Grade;
import ru.glavtoy.gradeaccounting.service.GradeService;

import java.util.List;

@RestController
@RequestMapping("/api/grades")
@AllArgsConstructor
@Tag(name = "Контроллер оценок", description = "Управление оценками студентов")
public class GradeController {

    private GradeService gradeService;

    @Operation(
            summary = "Добавляет оценку студенту",
            description = "Принимает на вход ID студента, данные оценки (предмет, балл) и добавляет в базу"
    )
    @PostMapping("/add_grade/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Оценка добавлена успешно"),
            @ApiResponse(responseCode = "404", description = "Студент не существует")
    })
    public ResponseEntity<GradeDTO> addGrade(@PathVariable Long id, @RequestBody GradeDTO gradeDTO) {
        GradeDTO grade = gradeService.addGrade(id, gradeDTO);
        if (grade.getTimestamp() != null) {
            return new ResponseEntity<>(grade, HttpStatus.OK);
        }
        return new ResponseEntity<>(grade, HttpStatus.NOT_FOUND);
    }

    @Operation(
            summary = "Возвращает все оценки студента",
            description = "Принимает на вход ID студента и возвращает список из всех его оценок (предмет, балл, дата)"
    )
    @GetMapping("/student_grades/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список оценок получен успешно"),
    })
    public ResponseEntity<List<GradeDTO>> getAllGrades(@PathVariable Long id) {
        return new ResponseEntity<>(gradeService.getAllGrades(id), HttpStatus.OK);
    }

    @Operation(
            summary = "Возвращает общий средний балл студента",
            description = "Принимает на вход ID студента и возвращает общий средний балл по всем предметам"
    )
    @GetMapping("/overall_gpa/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Общий средний балл получен успешно"),
    })
    public ResponseEntity<Double> getOverallGPA(@PathVariable Long id) {
        return new ResponseEntity<>(gradeService.getOverallGPA(id), HttpStatus.OK);
    }

    @Operation(
            summary = "Удаляет оценку студенту",
            description = "Принимает на вход ID оценки и удаляет из базы"
    )
    @DeleteMapping("/delete_grade/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Оценка удалена успешно"),
            @ApiResponse(responseCode = "404", description = "Оценка не существует")
    })
    public ResponseEntity<Grade> deleteGrade(@PathVariable Long id) {
        Grade grade = gradeService.deleteGrade(id);
        if (grade.getTimestamp() != null) {
            return new ResponseEntity<>(grade, HttpStatus.OK);
        }
        return new ResponseEntity<>(grade, HttpStatus.NOT_FOUND);
    }
}


