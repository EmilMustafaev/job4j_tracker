package ru.job4j.pojo;

public class Shop {
    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
    }

    public static int indexOfNull(Product[] products) {
        for (int index = 0; index < products.length; index++) {
            if (products[index] == null) {
                return index;
            }
        }
        return -1;
    }
}
