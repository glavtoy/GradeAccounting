package ru.glavtoy.gradeaccounting.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Schema(description = "Сущность для оценки студента")
public class Grade {
    @Schema(description = "Название предмета", example = "Математика")
    private String subject;
    @Schema(description = "Оценка", example = "5")
    private int value;
    @Schema(description = "Дата и время выставления оценки")
    private Date timestamp;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "Уникальный идентификатор оценки", example = "1")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonBackReference
    @Schema(description = "Студент, которому принадлежит оценка")
    private Student student;
}
