package com.example.library.models;

import com.example.library.models.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Table(name = "readers")
@Entity
public class Reader extends BaseEntity {
    @NotNull
    @Column(name = "first_name")
    private String firstName;
    @NotNull
    @Column(name = "last_name")
    private String lastName;
    @NotNull
    @Column(name = "phone")
    private String phone;
    @NotNull
    @Column(name = "email")
    private String email;
    @NotNull
    @Column(name = "debt")
    private Boolean debt;

    public Reader(String firstName, String lastName, String phone, String email, Boolean debt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.debt = debt;
    }
}
