package ru.job4j.lombock;


import lombok.*;

import java.util.List;

@Builder(builderMethodName = "of")
@EqualsAndHashCode
public class Permission {
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String name;

    @Singular("rule")
    private List<String> rules;
}
