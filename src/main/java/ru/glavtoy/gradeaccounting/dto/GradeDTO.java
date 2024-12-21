package ru.glavtoy.gradeaccounting.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Builder
public class GradeDTO {
    private String subject;
    private int value;
    private Date timestamp;
}
