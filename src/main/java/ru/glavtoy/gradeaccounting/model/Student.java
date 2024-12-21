package ru.glavtoy.gradeaccounting.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Schema(description = "Сущность для студента")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    @Schema(description = "Уникальный идентификатор студента", example = "1")
    private Long id;

    @Schema(description = "Имя студента", example = "Иван")
    private String firstname;
    @Schema(description = "Фамилия студента", example = "Иванов")
    private String lastname;
    @Schema(description = "Кампус студента", example = "Центральный")
    private String campus;

    @ManyToAny
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    @Schema(description = "Список оценок студента")
    private List<Grade> grades = new ArrayList<>();
}
