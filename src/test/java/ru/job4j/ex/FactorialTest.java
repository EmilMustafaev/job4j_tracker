package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    void whenException() {
        Factorial factorial = new Factorial();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    factorial.calc(-5);
                });
        assertThat(exception.getMessage()).isEqualTo("Number could not be less than 0");
    }
}