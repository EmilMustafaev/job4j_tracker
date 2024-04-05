package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book bookCleanCode = new Book("Clean Code");
        Book book1984 = new Book("1984");
        Book bookTheHobbit = new Book("The Hobbit");
        Book bookDracula = new Book("Dracula");
        Book[] books = new Book[4];
        books[0] = bookCleanCode;
        books[1] = book1984;
        books[2] = bookTheHobbit;
        books[3] = bookDracula;

        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println("Book name: " + book.getName());
        }

        Book item = books[0];
        books[0] = books[3];
        books[3] = item;

        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName());
        }
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            if ("Clean Code".equals(book.getName())) {
                System.out.println(book.getName());
            }
        }
    }
}
