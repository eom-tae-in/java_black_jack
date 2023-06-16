package dto;

public class ResultDto {

    private int win;
    private int drew;
    private int lose;

    public ResultDto(int win, int drew, int lose) {
        this.win = win;
        this.drew = drew;
        this.lose = lose;
    }

    public int getWin() {
        return win;
    }

    public int getDrew() {
        return drew;
    }

    public int getLose() {
        return lose;
    }

    public void addWin() {
        this.win++;
    }

    public void addDrew() {
        this.drew++;
    }

    public void addLose() {
        this.lose++;
    }
}
