package ru.glavtoy.gradeaccounting.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(description = "DTO для Student")
public class StudentDTO {
    @Schema(description = "Имя студента", example = "Иван")
    private String firstname;
    @Schema(description = "Фамилия студента", example = "Иванов")
    private String lastname;
    @Schema(description = "Кампус студента", example = "Центральный")
    private String campus;
}
