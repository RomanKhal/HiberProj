package org.example.Entities;

import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;


@MappedSuperclass
public abstract class BaseEntity {
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    BaseEntity(){
        createdAt = LocalDateTime.now();
    }
}
