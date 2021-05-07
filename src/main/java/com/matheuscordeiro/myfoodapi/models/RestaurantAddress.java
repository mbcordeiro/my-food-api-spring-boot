package com.matheuscordeiro.myfoodapi.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Builder
@Table(name = "restaurant_address")
public class RestaurantAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String number;
    private String complement;
    private String district;
    private String cep;

    @ManyToOne
    @JoinColumn(name="city_id")
    private City city;

    @OneToOne(mappedBy = "restaurantAddress")
    private Restaurant restaurant;
}
