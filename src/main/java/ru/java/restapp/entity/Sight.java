package ru.java.restapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sight")
@Data
@NoArgsConstructor
public class Sight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "sight_name")
    private String sightName;

    @Column(name = "date_construction")
    private LocalDate dateConstruction;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "type_sight", length = 20)
    @Enumerated(EnumType.STRING)
    private TypeSight typeSight;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

}
