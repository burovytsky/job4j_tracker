package ru.job4j.tracker.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Властелин колец", 500);
        Book book2 = new Book("Clean code", 300);
        Book book3 = new Book("Великий Гетсби", 250);
        Book book4 = new Book("Видоизмененный углерод", 400);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " , " + books[i].getNumberOfPages());
        }
        books[0] = book4;
        books[3] = book1;
        System.out.println("Replace 0 to 3");
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " , " + books[i].getNumberOfPages());
        }
        System.out.println("Searching book");
        for (int i = 0; i < books.length; i++) {
            if (books[i].getName().equals("Clean code")) {
                System.out.println(books[i].getName() + " " + books[i].getNumberOfPages());
            }
        }
    }
}
