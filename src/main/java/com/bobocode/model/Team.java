package com.bobocode.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "team_name", nullable = false)
    private String teamName;

    @Column(name = "captain")
    private Player captain;

    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "team", cascade = CascadeType.PERSIST)
    private List<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
        player.setTeam(this);
    }

    public void removePayment(Player player) {
        players.add(player);
        player.setTeam(null);
    }
}
