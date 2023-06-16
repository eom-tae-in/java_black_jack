package view;

import domain.Player;
import domain.Dealer;
import domain.Players;
import java.util.ArrayList;
import static org.apache.commons.lang3.StringUtils.join;

public class OutputView {

    public void askName() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉽표 기준으로 분리)");
    }

    public void askMore(String name) {
        System.out.println(name + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
    }

    public void printDealerDrew() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public void printFirstDeck(Dealer dealer, Players players) {
        String playersName = players.getPlayersName();
        System.out.println(dealer.getName() + "와 " + playersName + "에게 2장을 나누었습니다.");
        printDealerFirstDeck(dealer);
        for (Player player : players.getPlayers()) {
            printPlayerDeck(player);
        }
    }

    private void printDealerFirstDeck(Dealer dealer) {
        System.out.println(dealer.getName() + ": " + dealer.showOnlyOne().getValueAndShape());
    }

    public void printPlayerDeck(Player player) {
        ArrayList<String> playerCards = new ArrayList<>();
        player.getDeck().forEach(card -> playerCards.add(card.getValueAndShape()));
        System.out.println(player.getName() + ": " + join(playerCards, ","));
    }


    public void printTotalDeck(Dealer dealer, Players players) {
        printDealerDeckWithSum(dealer);
        for (Player player : players.getPlayers()) {
            printPlayerDeckWithSum(player);
        }
    }

    private void printDealerDeckWithSum(Dealer dealer) {
        ArrayList<String> dealerCards = new ArrayList<>();
        dealer.getDeck().forEach(card -> dealerCards.add(card.getValueAndShape()));
        System.out.println(dealer.getName() + " 카드: " + join(dealerCards, ", ") + " - 결과 : " + dealer.getSum());
    }

    private void printPlayerDeckWithSum(Player player) {
        ArrayList<String> playerCards = new ArrayList<>();
        player.getDeck().forEach(card -> playerCards.add(card.getValueAndShape()));
        System.out.println(player.getName() + "카드: " + join(playerCards, ", ") + " - 결과: " + player.getSum());
    }

    public void printResult(Dealer dealer, Players players) {
        System.out.println("## 최종 승패");
        printDealerResult(dealer);
        for (Player player : players.getPlayers()) {
            printPlayerResult(player);
        }
    }

    private void printDealerResult(Dealer dealer) {
        System.out.println(dealer.getName() + ": " + dealer.getResult());
    }

    private void printPlayerResult(Player player) {
        System.out.println(player.getName() + ": " + player.getResult());
    }
}
