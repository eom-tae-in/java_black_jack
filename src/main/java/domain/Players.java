package domain;

import java.util.ArrayList;
import java.util.List;
import static org.apache.commons.lang3.StringUtils.join;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public void add(Player player) {
        this.players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public String getPlayersName() {
        ArrayList<String> playersName = new ArrayList<>();
        players.forEach(player -> playersName.add(player.getName()));
        return join(playersName, ", ");
    }
}
