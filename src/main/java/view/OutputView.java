package view;

import domain.Dealer;
import domain.Player;
import domain.Players;

public class OutputView {

    public void AskMore(Player player) {
        System.out.println(player.getName() + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
    }

    public void printDealerDrew() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    private void printDealerDeck(Dealer dealer) {
        String deck = dealer.getDeck().toString();
        deck = deck.substring(1, deck.length() - 1);
        System.out.println(dealer.getName() + " 카드: " + deck + " = 결과: "+ dealer.getSum());
    }
}
