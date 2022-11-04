package com.example.myProject.models;

public class Cell {
    private Integer id;

    private short health;
    private short max_health;
    private short radius;
    private short regen;

    public Cell() {}

    public Cell(short health, short max_health, short radius, short regen) {
        this.health = health;
        this.max_health = max_health;
        this.radius = radius;
        this.regen = regen;
    }

    public Integer getId() {
        return id;
    }

    public short getHealth() {
        return health;
    }

    public short getMax_health() {
        return max_health;
    }

    public short getRadius() {
        return radius;
    }

    public short getRegen() {
        return regen;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setHealth(short health) {
        this.health = health;
    }

    public void setMax_health(short max_health) {
        this.max_health = max_health;
    }

    public void setRadius(short radius) {
        this.radius = radius;
    }

    public void setRegen(short regen) {
        this.regen = regen;
    }
}
