package ru.job4j.tasks.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matchCounter = 11;
        int player = 1;
        System.out.println("Нужно вытянуть от 1 до 3 спичек. Игра началась");
        while (matchCounter > 0) {
            System.out.println("Игрок " + player + " тянет спички");
            int playerMove = Integer.parseInt(scanner.nextLine());
            matchCounter -= playerMove;
            System.out.println("Игрок " + player + " выятнул " + playerMove + " спичек. Осталось " + matchCounter + " спичек");
            if (matchCounter <= 0) {
                System.out.println("Игрок " + player + " победил");
            }
            player = (player == 1) ? 2 : 1;
        }
    }
}
