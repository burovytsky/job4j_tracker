package ru.job4j.tracker.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matchCounter = 11;
        System.out.println("Нужно вытянуть от 1 до 3 спичек. Игра началась");
        while (true) {
            System.out.println("Первый игрок тянет спички");
            int firstPlayerMove = Integer.parseInt(scanner.nextLine());
            matchCounter -= firstPlayerMove;
            System.out.println("Игрок один выятнул " + firstPlayerMove + " спичек. Осталось " + matchCounter + " спичек");
            if (matchCounter <= 0) {
                System.out.println("Первый Игрок победил");
                break;
            }
            System.out.println("Второй Игрок тянет спички");
            int secondPlayerMove = Integer.parseInt(scanner.nextLine());
            matchCounter -= secondPlayerMove;
            System.out.println("Игрок два выятнул " + secondPlayerMove + " спичек. Осталось " + matchCounter + " спичек");
            if (matchCounter <= 0) {
                System.out.println("Второй Игрок победил");
                break;
            }
        }
    }
}
