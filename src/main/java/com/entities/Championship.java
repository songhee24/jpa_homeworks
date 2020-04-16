package com.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "championship")
public class Championship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_country",referencedColumnName = "id")
    private Country country;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_sport_kind")
    private KindOfSport kindOfSport;

    public Championship(String name, Country country, KindOfSport kindOfSport) {
        this.name = name;
        this.country = country;
        this.kindOfSport = kindOfSport;
    }
}
