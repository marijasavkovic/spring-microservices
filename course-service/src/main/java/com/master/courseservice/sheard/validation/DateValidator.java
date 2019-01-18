package com.master.courseservice.sheard.validation;

import java.util.Date;

public class DateValidator {

    public static Error dateInPast(Date date, String columnName) {
        if(date == null){
            return new Error(columnName + " must be in the past!");
        }

        if (!date.before(new Date())) {
            return new Error(columnName + " must be in the past!");
        }

        return null;
    }
}
