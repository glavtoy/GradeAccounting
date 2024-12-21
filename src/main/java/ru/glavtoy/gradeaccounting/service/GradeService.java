package ru.glavtoy.gradeaccounting.service;

import ru.glavtoy.gradeaccounting.dto.GradeDTO;
import ru.glavtoy.gradeaccounting.model.Grade;

import java.util.List;

public interface GradeService {
    GradeDTO addGrade(Long studentId, GradeDTO gradeDTO);
    Grade deleteGrade(Long id);
    Double getOverallGPA(Long id);
    List<GradeDTO> getAllGrades(Long id);
}
