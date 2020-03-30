package ru.job4j.tracker.ex;

public class ElementNotFoundException extends Exception {
    public static void main(String[] args) {
        String[] values = new String[]{"element1"};
        try {
            indexOf(values, "element");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int indexOf(String[] values, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < values.length; i++) {
            if (values[i].equals(key)) {
                rsl = i;
            } else {
                throw new ElementNotFoundException();
            }
        }
        return rsl;
    }
}
