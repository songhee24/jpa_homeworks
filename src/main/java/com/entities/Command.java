package com.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "command")
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "logo_address")
    private String logoAddress;
    @Column(name = "official_site")
    private String officialSide;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_sport_kind")
    private KindOfSport kindOfSport;


    public Command(String name, String logoAddress, String officialSide, KindOfSport kindOfSport) {
        this.name = name;
        this.logoAddress = logoAddress;
        this.officialSide = officialSide;
        this.kindOfSport = kindOfSport;
    }
}
