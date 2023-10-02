package com.example.library.models.base;

import jakarta.persistence.*;
import lombok.Data;


@Entity
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

}
