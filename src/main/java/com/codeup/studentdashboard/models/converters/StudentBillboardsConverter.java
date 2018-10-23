package com.codeup.studentdashboard.models.converters;

import com.codeup.studentdashboard.models.enums.StudentBillboards;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class StudentBillboardsConverter implements AttributeConverter<StudentBillboards, String> {
    @Override
    public String convertToDatabaseColumn(StudentBillboards studentBillboards) {
        switch (studentBillboards) {
            case YES:
                return "YES";
            case NO:
                return "NO";
            case DONT_REMEMBER:
                return "DON'T REMEMBER";
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
            case "DON'T REMEMBER":
                return StudentBillboards.DONT_REMEMBER;
            default:
                throw new IllegalArgumentException("Unknown" + s);
        }
    }
}
