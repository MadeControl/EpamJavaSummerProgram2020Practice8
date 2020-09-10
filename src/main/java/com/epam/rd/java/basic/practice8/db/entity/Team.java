package com.epam.rd.java.basic.practice8.db.entity;

import java.util.Objects;

public class Team {

    private String name;

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    public static Team createTeam(String name) {
        return new Team(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        return Objects.equals(name, team.name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
