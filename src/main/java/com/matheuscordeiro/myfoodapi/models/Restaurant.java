package com.matheuscordeiro.myfoodapi.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
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
    private String name;

    @Size(max = 14)
    @Column(nullable = false, unique = true)
    private String cnpj;

    @Column(nullable = false, unique = true)
    private String corporateName;

    private Integer restaurantPhone;
    private boolean isHasDeliveryService;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_address_id", referencedColumnName = "id")
    private RestaurantAddress restaurantAddress;

    @OneToOne
    @JoinColumn(name = "restaurant_specialty_id", referencedColumnName = "id")
    private List<RestaurantSpecialty> restaurantSpecialties;
}
