package org.dev.module7;

public class Worker {
    private String name;
    private int salary;

    public Worker(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName(){
        return name;
    }

    public int getSalary(){
        return salary;
    }
}
