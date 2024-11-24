package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StartUITest {
    @Test
    void whenCreateItem() {
        Output output = new StubOutput();
        Input input = new MockInput(
                new String[]{"0", "Item name", "1"}
        );
        MemTracker tracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<>(Arrays.asList(
                new CreateAction(output),
                new ExitAction(output)));
        new StartUI(new StubOutput()).init(input, tracker, actions);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceItem() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input input = new MockInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>(Arrays.asList(
                new ReplaceAction(output),
                new ExitAction(output)));
        new StartUI(new StubOutput()).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    void whenDeleteItem() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input input = new MockInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>(Arrays.asList(
                new DeleteAction(output),
                new ExitAction(output)));
        new StartUI(new StubOutput()).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    void whenReplaceItemTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input input = new MockInput(
                new String[]{"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>(Arrays.asList(
                new ReplaceAction(output),
                new ExitAction(output)));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Изменить заявку" + ln
                        + "1. Завершить программу" + ln
                        + "=== Редактирование заявки ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Меню:" + ln
                        + "0. Изменить заявку" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindAllActionTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test2"));
        Input input = new MockInput(
                new String[]{"0", "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>(Arrays.asList(
                new FindAllAction(output),
                new ExitAction(output)));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo("Меню:" + ln
                + "0. Показать все заявки" + ln
                + "1. Завершить программу" + ln
                + "=== Вывод всех заявок ===" + ln
                + one + ln
                + "Меню:" + ln
                + "0. Показать все заявки" + ln
                + "1. Завершить программу" + ln
                + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindByNameActionTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("TEST"));
        String findName = "TEST";
        Input input = new MockInput(
                new String[]{"0", findName, "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>(Arrays.asList(
                new FindByNameAction(output),
                new ExitAction(output)));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод заявок по имени ===" + ln
                        + one + ln
                        + "Меню:" + ln
                        + "0. Показать заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindByIdActionTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("TEST"));
        int findID = one.getId();
        Input input = new MockInput(
                new String[]{"0", String.valueOf(findID), "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>(Arrays.asList(
                new FindByIdAction(output),
                new ExitAction(output)));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод заявки по id ===" + ln
                        + one + ln
                        + "Меню:" + ln
                        + "0. Показать заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenInvalidExit() {
        Output output = new StubOutput();
        Input input = new MockInput(
                new String[]{"5", "0"}
        );
        MemTracker tracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<>(Arrays.asList(
                new ExitAction(output)));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Завершить программу" + ln
                        + "Неверный ввод, вы можете выбрать: 0 .. 0" + ln
                        + "Меню:" + ln
                        + "0. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    public void whenItemWasReplacedFailed() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        ReplaceAction replaceAction = new ReplaceAction(output);

        Input input = mock(Input.class);

        replaceAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Редактирование заявки ===" + ln
                        + "Ошибка замены заявки." + ln
        );
    }

    @Test
    public void whenItemWasReplacedSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        ReplaceAction replaceAction = new ReplaceAction(output);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        replaceAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Редактирование заявки ===" + ln
                        + "Заявка изменена успешно." + ln
        );
    }

    @Test
    public void whenItemWasDeletedSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("Deleted Item");
        tracker.add(item);
        DeleteAction deleteAction = new DeleteAction(output);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        deleteAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Удаление заявки ===" + ln
                        + "Заявка удалена успешно." + ln
        );
    }

    @Test
    public void whenItemWasDeletedFailed() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("Deleted Item");
        tracker.add(item);
        DeleteAction deleteAction = new DeleteAction(output);

        Input input = mock(Input.class);

        deleteAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Удаление заявки ===" + ln
                        + "Ошибка удаления заявки." + ln
        );
    }

    @Test
    public void whenItemWasFindByIdSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("Item");
        tracker.add(item);
        FindByIdAction findByIdAction = new FindByIdAction(output);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);

        findByIdAction.execute(input, tracker);
        Item expected = tracker.findById(item.getId());

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Вывод заявки по id ===" + ln
                        + expected + ln
        );
    }

    @Test
    public void whenItemWasFindByIdFailed() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("Item");
        FindByIdAction findByIdAction = new FindByIdAction(output);

        Input input = mock(Input.class);

        findByIdAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Вывод заявки по id ===" + ln
                        + "Заявка с введенным id: " + item.getId() + " не найдена." + ln
        );
    }

    @Test
    public void whenItemWasFindByNameSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("Item");
        tracker.add(item);
        String findName = "Item";
        FindByNameAction findByNameAction = new FindByNameAction(output);

        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(findName);

        findByNameAction.execute(input, tracker);
        List<Item> foundItems = tracker.findByName(item.getName());

        String ln = System.lineSeparator();
        StringBuilder expectedOutput = new StringBuilder("=== Вывод заявок по имени ===" + ln);
        for (Item foundItem : foundItems) {
            expectedOutput.append(foundItem).append(ln);
        }
        assertThat(output.toString()).isEqualTo(expectedOutput.toString());
    }

    @Test
    public void whenItemWasFindByNameFailed() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("Item");
        tracker.add(item);
        String findName = "Item123";
        FindByNameAction findByNameAction = new FindByNameAction(output);

        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(findName);
        findByNameAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Вывод заявок по имени ===" + ln
                        + "Заявки с именем: " + findName + " не найдены." + ln
        );
    }
}