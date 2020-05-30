package ru.job4j.tasks.oop;

public class DummyDic {
    public String engToRus(String eng) {
        return "Неизвестное слово - " + eng;
    }

    public static void main(String[] args) {
        DummyDic dummyDic = new DummyDic();
        String translate = dummyDic.engToRus("Hello");
        System.out.println(translate);
    }
}
