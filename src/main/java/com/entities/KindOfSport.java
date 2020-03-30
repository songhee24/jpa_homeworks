package com.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "sport_kind")
public class KindOfSport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;


    @OneToMany(
            mappedBy = "kindOfSport",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private List<Command> commands;

    @ManyToMany(mappedBy = "kindOfSport",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Championship> championships;

    public KindOfSport(String name) {
        this.name = name;
    }

    public KindOfSport(String name, List<Command> commands, List<Championship> championships) {
        this.name = name;
        this.commands = commands;
        this.championships = championships;
    }

//    @Override
//    public String toString() {
//        String d = "-";
//        String res = "";
//        String ret = "";
//        res = StringUtils.join(commands,"|");
//        return ret + " id:" + id + " name:" + name + " commands"+res;
//    }


/*    @Override
    public String toString() {
        StringBuilder b =new StringBuilder();
        String s = commands.stream().map(Command::toString).reduce("",String::concat);
        return "KindOfSport{" +
                "id=" + id + ", name=" + name + " command=" + s + '}';
    }*/

    @Override
    public String toString() {
        return "KindOfSport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", commands=" + commands +
                '}';
    }
}


