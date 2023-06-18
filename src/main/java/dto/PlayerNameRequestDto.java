package dto;

public class PlayerNameRequestDto {
    private final String[] playerNames;

    public PlayerNameRequestDto(String[] playerNames) {
        this.playerNames = playerNames;
    }

    public String[] getPlayerNames() {
        return playerNames;
    }
}
