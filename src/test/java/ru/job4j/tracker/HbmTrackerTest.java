package ru.job4j.tracker;

import org.hibernate.Session;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

class HbmTrackerTest {
    private HbmTracker tracker;

    @BeforeEach
    void setUp() {
        tracker = new HbmTracker();
    }

    @AfterEach
    void tearDown() {
        tracker.close();
    }

    private void clearDatabase() {
        Session session = tracker.getSessionFactory().openSession();
        session.beginTransaction();
        session.createQuery("DELETE FROM Item").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Test
    void whenAddItemThenFindIt() {
        Item item = new Item();
        item.setName("Test Item");
        tracker.add(item);
        Item expected = tracker.findById(item.getId());
        assertEquals(item, expected);
        clearDatabase();
    }

    @Test
    void whenReplaceItemThenFindUpdatedItem() {
        Item item = new Item();
        item.setName("Old Name");
        tracker.add(item);

        Item updatedItem = new Item();
        updatedItem.setName("New Name");
        boolean replaced = tracker.replace(item.getId(), updatedItem);

        assertTrue(replaced);
        Item expected = tracker.findById(item.getId());
        assertNotNull(expected);
        assertEquals("New Name", expected.getName());
        clearDatabase();
    }

    @Test
    void whenDeleteItemThenNotFound() {
        Item item = new Item();
        item.setName("To Be Deleted");
        tracker.add(item);

        tracker.delete(item.getId());
        Item expected = tracker.findById(item.getId());
        assertNull(expected);
        clearDatabase();
    }

    @Test
    void whenFindAllThenReturnAllItems() {
        Item item1 = new Item();
        item1.setName("Item 1");
        Item item2 = new Item();
        item2.setName("Item 2");

        tracker.add(item1);
        tracker.add(item2);

        List<Item> allItems = tracker.findAll();
        assertEquals(2, allItems.size());
        assertTrue(allItems.contains(item1));
        assertTrue(allItems.contains(item2));
        clearDatabase();
    }

    @Test
    void whenFindByNameThenReturnMatchingItems() {
        Item item1 = new Item();
        item1.setName("Same Name");
        Item item2 = new Item();
        item2.setName("Same Name");
        Item item3 = new Item();
        item3.setName("Different Name");

        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);

        List<Item> foundItems = tracker.findByName("Same Name");
        assertEquals(2, foundItems.size());
        assertTrue(foundItems.contains(item1));
        assertTrue(foundItems.contains(item2));
        clearDatabase();
    }

    @Test
    void whenFindByIdThenReturnItem() {
        Item item = new Item();
        item.setName("Unique Item");
        tracker.add(item);

        Item expected = tracker.findById(item.getId());
        assertNotNull(expected);
        assertEquals(item, expected);
        clearDatabase();
    }

    @Test
    void whenFindByIdNonExistingThenReturnNull() {
        Item expected = tracker.findById(999);
        assertNull(expected);
        clearDatabase();
    }
}