package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
            return true;
        } else {
            return false;
        }
    }

    public void delete(int id) {
        int index = indexOf(id);
        int start = index + 1;
        int distPos = index;
        int length = size - index - 1;
        if (index != -1) {
            System.arraycopy(items, start, items, distPos, length);
            items[size - 1] = null;
            size--;
        }

    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] result = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            if (items[index] != null) {
                result[size] = items[index];
                size++;
            }
        }
        result = Arrays.copyOf(items, size);
        return result;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[size];
        int count = 0;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (key.equals(item.getName())) {
                result[count] = item;
                count++;
            }
        }
        result = Arrays.copyOf(result, count);
        return result;
    }
}