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
        for (int i = 0; i < queue.size(); i++) {
            Customer lastCustomer = queue.poll();
            product--;
            if (product == 0) {
                result = lastCustomer.name();
                break;
            }
        }
        return result;
    }

    public String getFirstUpsetCustomer() {
        String result = "";
        int product = this.count;
        for (int i = 0; i < queue.size(); i++) {
            if (product == 0) {
                break;
            }
            product--;
            queue.remove();
        } Customer firstCustomer = queue.poll();
        result = firstCustomer.name();
        return result;
    }
}
