package com.codeup.studentdashboard.models.converters;

import com.codeup.studentdashboard.models.enums.StudentGender;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class StudentGenderConverter implements AttributeConverter<StudentGender, java.lang.String> {
    @Override
    public java.lang.String convertToDatabaseColumn(StudentGender studentGender) {
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
    public StudentGender convertToEntityAttribute(java.lang.String s) {
        switch (s) {
            case "MALE":
                return StudentGender.MALE;
            case "FEMALE":
                return StudentGender.FEMALE;
            case "OTHER":
                return StudentGender.OTHER;
            default:
                throw new IllegalArgumentException("Unknown" + s);
        }
    }
}
