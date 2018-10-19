package com.codeup.studentdashboard.models.enums;

import javax.persistence.AttributeConverter;

public class StudentBillboardsConverter implements AttributeConverter<StudentBillboards, String> {
    @Override
    public String convertToDatabaseColumn(StudentBillboards studentBillboards) {
        switch (studentBillboards) {
            case YES:
                return "YES";
            case NO:
                return "NO";
            case DONT_KNOW:
                return "I DON'T KNOW";
            default:
                throw new IllegalArgumentException("Unknown" + studentBillboards);
        }
    }

    @Override
    public StudentBillboards convertToEntityAttribute(String s) {
        switch (s) {
            case "YES":
                return StudentBillboards.YES;
            case "NO":
                return StudentBillboards.NO;
            case "I DON'T KNOW":
                return StudentBillboards.DONT_KNOW;
            default:
                throw new IllegalArgumentException("Unknown" + s);
        }
    }
}
