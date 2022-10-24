package pl.model;

public class WhatNumberIsItDescription {
    private String name;


    public WhatNumberIsItDescription() {
    }

    public WhatNumberIsItDescription(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "WhatNumberIsItDescription{" +
                "name='" + name + '\'' +
                '}';
    }
}
