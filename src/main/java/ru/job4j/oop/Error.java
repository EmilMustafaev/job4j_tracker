package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void showInfo() {
        System.out.println("Active: " + active);
        System.out.println(("Status: " + status));
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        Error errorOne = new Error();
        Error errorTwo = new Error(true, 5, "errorTwo");
        Error errorThree = new Error(false, 3, "errorThree");
        errorOne.showInfo();
        errorTwo.showInfo();
        errorThree.showInfo();
    }
}
