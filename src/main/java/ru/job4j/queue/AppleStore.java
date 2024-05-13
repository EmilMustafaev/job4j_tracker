package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        String result = "";
        int product = this.count;
        for (Customer customer : queue) {
            product--;
            if (product == 0) {
                result = customer.name();
                break;
            }
        }
        return result;
    }

    public String getFirstUpsetCustomer() {
        String result = "";
        int product = this.count;
        for (Customer customer : queue) {
            product--;
            if (product < 0) {
                result = customer.name();
                break;
            }
        }
        return result;
    }
}
