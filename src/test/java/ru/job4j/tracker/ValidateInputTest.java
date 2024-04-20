package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Выбрать: ");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenMultipleInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"1", "2", "3"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Выбрать: ");
        assertThat(selected).isEqualTo(1);
        int selected2 = input.askInt("Выбрать: ");
        assertThat(selected2).isEqualTo(2);
        int selected3 = input.askInt("Выбрать: ");
        assertThat(selected3).isEqualTo(3);
    }

    @Test
    void whenValidNegativeNumberInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"-1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Выбрать: ");
        assertThat(selected).isEqualTo(-1);
    }
}