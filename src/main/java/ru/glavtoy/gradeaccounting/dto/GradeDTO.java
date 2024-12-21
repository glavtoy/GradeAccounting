package ru.glavtoy.gradeaccounting.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Builder
@Schema(description = "DTO для Grade")
public class GradeDTO {
    @Schema(description = "Название предмета", example = "Математика")
    private String subject;
    @Schema(description = "Оценка", example = "5")
    private int value;
    @Schema(description = "Дата и время выставления оценки")
    private Date timestamp;
}
