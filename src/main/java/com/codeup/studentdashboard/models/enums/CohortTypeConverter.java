package com.codeup.studentdashboard.models.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class CohortTypeConverter implements AttributeConverter<CohortType, String> {

    @Override
    public String convertToDatabaseColumn(CohortType cohortType) {
        switch (cohortType) {
            case WEB:
                return "WEB";
            case DATA:
                return "DATA";
            default:
                throw new IllegalArgumentException("Unknown" + cohortType);
        }
    }

    @Override
    public CohortType convertToEntityAttribute(String s) {
        switch (s) {
            case "WEB":
                return CohortType.WEB;
            case "DATA":
                return CohortType.DATA;
            default:
                throw new IllegalArgumentException("Unknown" + s);
        }
    }
}
