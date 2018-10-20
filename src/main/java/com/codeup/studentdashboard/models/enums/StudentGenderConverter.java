package com.codeup.studentdashboard.models.enums;

import javax.persistence.AttributeConverter;

public class StudentGenderConverter implements AttributeConverter<StudentGender, String> {
    @Override
    public String convertToDatabaseColumn(StudentGender studentGender) {
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
    public StudentGender convertToEntityAttribute(String s) {
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
