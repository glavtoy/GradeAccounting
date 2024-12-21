package ru.glavtoy.gradeaccounting.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.glavtoy.gradeaccounting.dto.GradeDTO;
import ru.glavtoy.gradeaccounting.model.Grade;
import ru.glavtoy.gradeaccounting.model.Student;
import ru.glavtoy.gradeaccounting.repository.GradeRepository;
import ru.glavtoy.gradeaccounting.repository.StudentRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class GradeServiceImpl implements GradeService {

    private StudentRepository studentRepository;
    private GradeRepository gradeRepository;

    public GradeDTO addGrade(Long studentId, GradeDTO gradeDTO) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null) {
            Grade grade = new Grade();
            grade.setSubject(gradeDTO.getSubject());
            grade.setValue(gradeDTO.getValue());
            grade.setStudent(student);
            grade.setTimestamp(new Date());
            student.getGrades().add(grade);
            studentRepository.save(student);
            return GradeDTO.builder()
                    .value(grade.getValue())
                    .subject(grade.getSubject())
                    .timestamp(grade.getTimestamp()).build();
        }
        return GradeDTO.builder().build();
    }

    public Grade deleteGrade(Long id) {
        Grade grade = gradeRepository.findById(id).orElse(null);
        if (grade != null) {
            gradeRepository.delete(grade);
            return grade;
        }
        return new Grade();
    }

    @Override
    public Double getOverallGPA(Long id) {
        double gpa = 0;
        List<Grade> grades = new ArrayList<>(gradeRepository.getGradeByStudentId(id));
        for (Grade grade : grades) {
            gpa += grade.getValue();
        }
        return gpa / grades.size();
    }
}
