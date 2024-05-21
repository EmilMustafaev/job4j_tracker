package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {

    @Test
    void compareAscByDefault() {
        List<Item> items = Arrays.asList(
                new Item("Exception"),
                new Item("Error"),
                new Item("Bug")
        );
        List<Item> expected = Arrays.asList(
                new Item("Bug"),
                new Item("Error"),
                new Item("Exception")
        );
        Collections.sort(items);
        assertThat(items).isEqualTo(expected);
    }

    @Test
    void compareAscByName() {
        List<Item> items = Arrays.asList(new Item("Bug"),
                new Item("Error"), new Item("Exception"));
        List<Item> expected = Arrays.asList(
                new Item("Bug"),
                new Item("Error"),
                new Item("Exception")
        );
        items.sort(new ItemAscByName());
        assertThat(items).isEqualTo(expected);
    }

    @Test
    void compareDescByName() {
        List<Item> items = Arrays.asList(new Item("Bug"),
                new Item("Error"), new Item("Exception"));
        List<Item> expected = Arrays.asList(
                new Item("Exception"),
                new Item("Error"),
                new Item("Bug")
        );
        items.sort(new ItemDescByName());
        assertThat(items).isEqualTo(expected);
    }

}