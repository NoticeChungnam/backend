package com.backend.academic_schedule.presentation;

import com.backend.academic_schedule.presentation.status.Month;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MonthConverter implements Converter<String, Month> {

    @Override
    public Month convert(String month) {
        return Month.from(Integer.parseInt(month));
    }
}
