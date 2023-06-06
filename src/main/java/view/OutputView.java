package view;

import domain.Player;
import domain.Players;

public class OutputView {

    public void AskMore(Player player) {
        System.out.println(player.getName() + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
    }
}
