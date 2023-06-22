package domain;

import java.util.Collections;
import java.util.List;

public class Players {
    private final List<Player> players;

    public Players(final List<Player> players) {
        this.players = players;
    }

    public void add(final Player player) {
        this.players.add(player);
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
