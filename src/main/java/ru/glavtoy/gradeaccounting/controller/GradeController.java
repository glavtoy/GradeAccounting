package ru.glavtoy.gradeaccounting.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.glavtoy.gradeaccounting.dto.GradeDTO;
import ru.glavtoy.gradeaccounting.model.Grade;
import ru.glavtoy.gradeaccounting.service.GradeService;

@RestController
@RequestMapping("/api/grades")
@AllArgsConstructor
public class GradeController {

    private GradeService gradeService;

    @PostMapping("/add_grade/{id}")
    public ResponseEntity<GradeDTO> addGrade(@PathVariable Long id, @RequestBody GradeDTO gradeDTO) {
        return new ResponseEntity<>(gradeService.addGrade(id, gradeDTO), HttpStatus.OK);
    }

    @GetMapping("/overall_gpa/{id}")
    public ResponseEntity<Double> getOverallGPA(@PathVariable Long id) {
        return new ResponseEntity<>(gradeService.getOverallGPA(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete_grade/{id}")
    public ResponseEntity<Grade> deleteGrade(@PathVariable Long id) {
        return new ResponseEntity<>(gradeService.deleteGrade(id), HttpStatus.OK);
    }
}


