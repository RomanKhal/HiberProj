package org.example.Entities;

import jakarta.persistence.Entity;

@Entity
public class Task extends BaseEntity {
    private String name;

    public Task(){};

    public Task(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                '}';
    }
}
