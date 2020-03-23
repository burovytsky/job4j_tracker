package ru.job4j.tracker.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Ivan Ivanov");
        student.setGroup("SE-140");
        student.setEntryDate(new Date());

        System.out.println(student.getFullName() + ". Group : " + student.getGroup() + ". Entry date : " + student.getEntryDate());
    }
}
