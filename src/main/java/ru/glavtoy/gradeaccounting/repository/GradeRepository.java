package ru.glavtoy.gradeaccounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.glavtoy.gradeaccounting.model.Grade;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> getGradeByStudentId(Long id);
}
