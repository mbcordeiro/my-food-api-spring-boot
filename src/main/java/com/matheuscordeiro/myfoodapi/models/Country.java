package com.matheuscordeiro.myfoodapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Size(max = 2)
    private String initials;

    @JsonIgnore
    @OneToMany(mappedBy = "country")
    private List<State> states = new ArrayList<>();
}
