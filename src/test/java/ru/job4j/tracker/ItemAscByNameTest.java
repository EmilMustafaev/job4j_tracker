package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {

    @Test
    void compareAscByDefault() {
        List<Item> items = Arrays.asList(new Item("Bug"),
                new Item("Error"), new Item("Exception"));
        Collections.sort(items);
        List<Item> expected = items;
        assertThat(items).isEqualTo(expected);
    }

    @Test
    void compareAscByName() {
        List<Item> items = Arrays.asList(new Item("Bug"),
                new Item("Error"), new Item("Exception"));
        items.sort(new ItemAscByName());
        List<Item> expected = items;
        assertThat(items).isEqualTo(expected);
    }

    @Test
    void compareDescByName() {
        List<Item> items = Arrays.asList(new Item("Bug"),
                new Item("Error"), new Item("Exception"));
        items.sort(new ItemDescByName());
        List<Item> expected = items;
        assertThat(items).isEqualTo(expected);
    }

}