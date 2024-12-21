package ru.glavtoy.gradeaccounting.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StudentDTO {
    private String firstname;
    private String lastname;
    private String campus;
}
