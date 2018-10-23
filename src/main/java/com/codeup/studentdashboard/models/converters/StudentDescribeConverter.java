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
                return "I AM A TRANSITIONING VETERAN OR ACTIVE MILITARY.";
            case SERVICE:
                return "I CURRENTLY WORK IN THE SERVICE INDUSTRY AND LOOKING FOR A CAREER CHANGE.";
            case SAME:
                return "I HAVE BEEN IN THE SAME CAREER FOR OVER 5 YEARS AND LOOKING FOR A CAREER CHANGE.";
            case HS:
                return "I AM A RECENT HIGH SCHOOL GRADUATE AND LOOKING FOR ALTERNATIVE OPTIONS TO A COLLEGE/UNIVERSITY.";
            case COLLEGE:
                return "I AM A RECENT COLLEGE GRADUATE.";
            default:
                throw new IllegalArgumentException("Unknown" + studentDescribe);
        }
    }

    @Override
    public StudentDescribe convertToEntityAttribute(String s) {
        switch (s) {
            case "I AM A TRANSITIONING VETERAN OR ACTIVE MILITARY.":
                return StudentDescribe.VET_MIL;
            case "I CURRENTLY WORK IN THE SERVICE INDUSTRY AND LOOKING FOR A CAREER CHANGE.":
                return StudentDescribe.SERVICE;
            case "I HAVE BEEN IN THE SAME CAREER FOR OVER 5 YEARS AND LOOKING FOR A CAREER CHANGE.":
                return StudentDescribe.SAME;
            case "I AM A RECENT HIGH SCHOOL GRADUATE AND LOOKING FOR ALTERNATIVE OPTIONS TO A COLLEGE/UNIVERSITY.":
                return StudentDescribe.HS;
            case "I AM A RECENT COLLEGE GRADUATE.":
                return StudentDescribe.COLLEGE;
            default:
                throw new IllegalArgumentException("Unknown" + s);
        }
    }
}
