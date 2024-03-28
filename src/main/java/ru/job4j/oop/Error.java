package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    Error() {
    }

    Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void showInfo() {
        System.out.println(active);
        System.out.println((status));
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error errorOne = new Error();
        Error errorTwo = new Error(true, 5, "Message in errorTwo");
        Error errorThree = new Error(false, 3, "Message in errorThree");
        errorOne.showInfo();
        errorTwo.showInfo();
        errorThree.showInfo();
    }
}
