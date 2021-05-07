package com.matheuscordeiro.myfoodapi.models;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@Builder
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 11)
    @Column(nullable = false, unique = true)
    @NotNull
    private String name;

    @NotNull
    @Size(max = 14)
    @CNPJ
    @Column(nullable = false, unique = true)
    private String cnpj;

    @NotNull
    @Column(nullable = false, unique = true)
    private String corporateName;

    @NotNull
    private Integer restaurantPhone;

    private boolean isHasDeliveryService;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_address_id", referencedColumnName = "id")
    private RestaurantAddress restaurantAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_specialty_id", referencedColumnName = "id")
    private RestaurantSpecialty restaurantSpecialty;
}
