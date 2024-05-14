package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < evenElements.size(); i++) {
            Character ch = evenElements.peek();
            if (i % 2 == 0) {
                result.append(ch);
            }
            evenElements.add(evenElements.poll());
        }
        return result.toString();
    }

    private String getDescendingElements() {
        StringBuilder result = new StringBuilder();
        int size = descendingElements.size();
        for (int i = 0; i < size; i++) {
            Character element = descendingElements.pollLast();
            result.append(element);
        }
        return result.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}