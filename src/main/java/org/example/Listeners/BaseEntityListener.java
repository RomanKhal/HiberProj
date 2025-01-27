package org.example.Listeners;

import jakarta.persistence.*;
import org.example.Entities.BaseEntity;

import java.time.LocalDateTime;

public class BaseEntityListener {
    private LocalDateTime createdAtFixed;
    private final String format = "    %s class %s created %s updated %s%n";

    @PostLoad
    public void postLoad(BaseEntity e){
        createdAtFixed = e.getCreatedAt();
        System.out.printf(format,"postLoad", e.getClass().getSimpleName(), e.getCreatedAt(), e.getUpdatedAt());
    }
    @PostPersist
    public void postPersist(BaseEntity e) {
        createdAtFixed = e.getCreatedAt();
        e.setCreatedAt(LocalDateTime.now());
        System.out.printf(format,"postPersist", e.getClass().getSimpleName(), e.getCreatedAt(), e.getUpdatedAt());
    }

    @PreUpdate
    public void preUpdate(BaseEntity e) {
        e.setCreatedAt(createdAtFixed);
        e.setUpdatedAt(LocalDateTime.now());
        System.out.printf(format,"preUpdate", e.getClass().getSimpleName(), e.getCreatedAt(), e.getUpdatedAt());
    }

}
