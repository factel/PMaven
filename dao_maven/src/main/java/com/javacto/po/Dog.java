package com.javacto.po;

public class Dog {
    private int id;
    private double sal;
    private String breed;

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", sal=" + sal +
                ", breed='" + breed + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}