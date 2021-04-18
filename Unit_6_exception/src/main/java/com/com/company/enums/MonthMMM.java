package com.com.company.enums;

public enum MonthMMM {
    Jan(1), Feb(2), Mar(3), Apr(4), May(5), Jun(6), Jul(7), Aug(8), Sep(9), Oct(10), Nov(11), Dec(12);
    int numberOfMonth = 0;
    MonthMMM(int i) {
        this.numberOfMonth = i;
    }
//    public static MonthMMM valueOf(String s) {
//        for (MonthMMM item: values()) {
//            if(item.name().equals(s)) {
//                return item;
//            }
//        }
//        return null;
//    }
}
