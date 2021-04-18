package com.com.company.operations;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ConvertingToMs {
    Long convertToMs(Long day, Long month, Long year, Long hour, Long minute, Long sec, Long ms) {
        for (int i = 1; i <= year; i++) {
            if (i % 4 == 0 && i % 100 == 0 || i % 400 == 0) {
                day += 1;
            }
        }

        month = month+ (year * 12L);
        long result= 0L;
        day += (365L * month / 12);
        hour += (day * 24L);
        minute += (hour * 60L);
        sec += (minute * 60L);
        result = result + (sec * 1000L) + ms;
        return result;
        List<Integer> ks = new ArrayList<>()
    }

    public Boolean checkTheFormat(Long day, Long month, Long year, Long hour, Long minute, Long sec, Long ms) {
        return day <= 31 && day > 0 && month <= 12 && month > 0 && hour <= 24 && hour >= 0 && minute <= 60 && minute >= 0 &&
                sec <= 60 && sec >= 0 && year > 0 && ms < 1000;
    }
}
