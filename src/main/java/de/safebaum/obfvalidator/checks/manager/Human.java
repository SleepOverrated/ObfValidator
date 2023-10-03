package de.safebaum.obfvalidator.checks.manager;

public class Human {

    private String name;
    private int age;
    private double height;


    public Human(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }


    public int talk() {
        System.out.println("Hi from " + getName());
        return 1;
    }

}
