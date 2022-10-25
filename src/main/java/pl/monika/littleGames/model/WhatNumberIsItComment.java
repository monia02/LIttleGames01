package pl.monika.littleGames.model;

public class WhatNumberIsItComment {
    private String name;
    public WhatNumberIsItComment(String name) {
        this.name = name;
    }
    public WhatNumberIsItComment() {
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "WhatNumberIsItComment{" +
                "name='" + name + '\'' +
                '}';
    }
}
