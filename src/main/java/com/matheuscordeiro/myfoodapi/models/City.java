package com.matheuscordeiro.myfoodapi.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@Builder
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Size(max = 2)
    private String initials;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;
}
