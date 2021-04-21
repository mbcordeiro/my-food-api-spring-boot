package com.matheuscordeiro.myfoodapi.models;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@Builder
public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Integer phone;

    @NotNull
    @CPF
    @Size(max = 11)
    @Column(nullable = false, unique = true)
    private String cpf;

    private boolean isActive;

    @OneToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User user;
}
