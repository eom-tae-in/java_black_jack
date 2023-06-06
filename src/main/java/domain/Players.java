package domain;

import java.util.ArrayList;
import java.util.List;

public class Players {
    List<Player> players = new ArrayList<>();

    public List<Player> getPlayers() {
        return players;
    }

    public void add(Player player) {
        this.players.add(player);
    }
}
