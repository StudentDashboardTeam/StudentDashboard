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
                return "Yes";
            case NO:
                return "No";
            case DONT_REMEMBER:
                return "Don't remember";
            default:
                throw new IllegalArgumentException("Unknown" + studentBillboards);
        }
    }

    @Override
    public StudentBillboards convertToEntityAttribute(String s) {
        switch (s) {
            case "Yes":
                return StudentBillboards.YES;
            case "No":
                return StudentBillboards.NO;
            case "Don't remember":
                return StudentBillboards.DONT_REMEMBER;
            default:
                throw new IllegalArgumentException("Unknown" + s);
        }
    }
}
