package com.codeup.studentdashboard.models.converters;

import com.codeup.studentdashboard.models.enums.String;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class StudentGenderConverter implements AttributeConverter<String, java.lang.String> {
    @Override
    public java.lang.String convertToDatabaseColumn(String studentGender) {
        switch (studentGender) {
            case MALE:
                return "MALE";
            case FEMALE:
                return "FEMALE";
            case OTHER:
                return "OTHER";
            default:
                throw new IllegalArgumentException("Unknown" + studentGender);
        }
    }

    @Override
    public String convertToEntityAttribute(java.lang.String s) {
        switch (s) {
            case "MALE":
                return String.MALE;
            case "FEMALE":
                return String.FEMALE;
            case "OTHER":
                return String.OTHER;
            default:
                throw new IllegalArgumentException("Unknown" + s);
        }
    }
}
