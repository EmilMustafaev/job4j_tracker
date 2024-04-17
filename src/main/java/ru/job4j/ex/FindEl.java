package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int index = 0; index < value.length; index++) {
            if (key.equals(value[index])) {
                result = index;
                break;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("The element not be found");
        }
        return result;
    }

    public static void main(String[] args) {
        String[] names = {"Petr", "Ivan", "Nik", "Vasya"};
        try {
            FindEl.indexOf(names, "Emil");
        } catch (ElementNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
