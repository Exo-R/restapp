package ru.java.restapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "city")
@Data
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "population")
    private Integer population;

    @Column(name = "metro_availability")
    private Boolean metroAvailability;

    @Column(name = "country")
    private String country;

}
