package com.codeup.studentdashboard.models.converters;

import com.codeup.studentdashboard.models.enums.StudentDescribe;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class StudentDescribeConverter implements AttributeConverter<StudentDescribe, String> {
    @Override
    public String convertToDatabaseColumn(StudentDescribe studentDescribe) {
        switch (studentDescribe) {
            case VET_MIL:
                return "I am a transitioning Veteran or Active Military.";
            case SERVICE:
                return "I currently work in the service industry and looking for a career change.";
            case SAME:
                return "I have been in the same career for over 5 years and looking for a career change.";
            case HS:
                return "I am a recent high school graduate and looking for alternative options to a college/university.";
            case COLLEGE:
                return "I am a recent college graduate.";
            default:
                throw new IllegalArgumentException("Unknown" + studentDescribe);
        }
    }

    @Override
    public StudentDescribe convertToEntityAttribute(String s) {
        switch (s) {
            case "I am a transitioning Veteran or Active Military.":
                return StudentDescribe.VET_MIL;
            case "I currently work in the service industry and looking for a career change.":
                return StudentDescribe.SERVICE;
            case "I have been in the same career for over 5 years and looking for a career change.":
                return StudentDescribe.SAME;
            case "I am a recent high school graduate and looking for alternative options to a college/university.":
                return StudentDescribe.HS;
            case "I am a recent college graduate.":
                return StudentDescribe.COLLEGE;
            default:
                throw new IllegalArgumentException("Unknown" + s);
        }
    }
}
