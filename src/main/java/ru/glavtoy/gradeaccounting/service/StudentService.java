package ru.glavtoy.gradeaccounting.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.glavtoy.gradeaccounting.model.Grade;
import ru.glavtoy.gradeaccounting.model.Student;
import ru.glavtoy.gradeaccounting.repository.GradeRepository;
import ru.glavtoy.gradeaccounting.repository.StudentRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;
    private GradeRepository gradeRepository;

    public ResponseEntity<Student> getStudentById(Long id) {
        return new ResponseEntity<>(studentRepository.findById(id).orElse(new Student()), HttpStatus.OK);
    }

    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<String> addStudent(Student student) {
        if (student.getId() != null) {
            return new ResponseEntity<>("ID не должен быть установлен для нового студента", HttpStatus.BAD_REQUEST);
        }
        studentRepository.save(student);
        return new ResponseEntity<>("Студент зарегистрирован", HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteStudent(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            studentRepository.delete(student);
            return new ResponseEntity<>("Студент удалён", HttpStatus.OK);
        }
        return new ResponseEntity<>("Студент с таким ID не существует", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addGrade(Long studentId, Grade grade) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null) {
            grade.setStudent(student);
            grade.setTimestamp(new Date());
            student.getGrades().add(grade);
            studentRepository.save(student);
            String message = "Оценка " + grade.getValue() + " по предмету " + grade.getSubject() + " выставлена пользователю " + student.getName() + " (" + studentId + ") в " + grade.getTimestamp();
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        return new ResponseEntity<>("Студент с таким ID не существует", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteGrade(Long id) {
        Grade grade = gradeRepository.findById(id).orElse(null);
        if (grade != null) {
           gradeRepository.delete(grade);
            return new ResponseEntity<>("Оценка удалена", HttpStatus.OK);
        }
        return new ResponseEntity<>("Оценка с таким ID не существует", HttpStatus.BAD_REQUEST);
    }
}
