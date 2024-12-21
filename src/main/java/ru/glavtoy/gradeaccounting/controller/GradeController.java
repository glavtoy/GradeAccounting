package ru.glavtoy.gradeaccounting.controller;

import io.swagger.v3.oas.annotations.Operation;
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
public class GradeController {

    private GradeService gradeService;

    @Operation(
            summary = "Добавляет оценку студенту",
            description = "Принимает на вход ID студента, данные оценки (предмет, балл) и добавляет в базу"
    )
    @PostMapping("/add_grade/{id}")
    public ResponseEntity<GradeDTO> addGrade(@PathVariable Long id, @RequestBody GradeDTO gradeDTO) {
        return new ResponseEntity<>(gradeService.addGrade(id, gradeDTO), HttpStatus.OK);
    }

    @Operation(
            summary = "Возвращает все оценки студента",
            description = "Принимает на вход ID студента и возвращает список из всех его оценок (предмет, балл, дата)"
    )
    @GetMapping("/student_grades/{id}")
    public ResponseEntity<List<GradeDTO>> getAllGrades(@PathVariable Long id) {
        return new ResponseEntity<>(gradeService.getAllGrades(id), HttpStatus.OK);
    }

    @Operation(
            summary = "Возвращает общий средний балл студента",
            description = "Принимает на вход ID студента и возвращает общий средний балл по всем предметам"
    )
    @GetMapping("/overall_gpa/{id}")
    public ResponseEntity<Double> getOverallGPA(@PathVariable Long id) {
        return new ResponseEntity<>(gradeService.getOverallGPA(id), HttpStatus.OK);
    }

    @Operation(
            summary = "Удаляет оценку студенту",
            description = "Принимает на вход ID оценки и удаляет из базы"
    )
    @DeleteMapping("/delete_grade/{id}")
    public ResponseEntity<Grade> deleteGrade(@PathVariable Long id) {
        return new ResponseEntity<>(gradeService.deleteGrade(id), HttpStatus.OK);
    }
}


