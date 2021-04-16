package com.matheuscordeiro.myfoodapi.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Builder
public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer phone;
    private String cpf;
    private boolean isActive;

    @OneToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User user;
}
