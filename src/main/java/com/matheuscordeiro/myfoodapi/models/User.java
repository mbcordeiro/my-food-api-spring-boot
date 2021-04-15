package com.matheuscordeiro.myfoodapi.models;

import lombok.*;
import javax.persistence.*;

@Entity
@Data
@Builder
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String email;
    private String username;
    private String password;

    @OneToOne(mappedBy = "user")
    private Costumer costumer;
}
