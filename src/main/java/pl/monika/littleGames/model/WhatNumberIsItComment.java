package pl.monika.littleGames.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WhatNumberIsItComment that = (WhatNumberIsItComment) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
