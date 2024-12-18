package ru.glavtoy.gradeaccounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.glavtoy.gradeaccounting.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {}
