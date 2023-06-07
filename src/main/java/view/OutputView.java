package view;

import domain.Dealer;
import domain.Player;
import domain.Players;
import domain.Result;

public class OutputView {

    private StringBuilder sb;

    public void AskMore(Player player) {
        System.out.println(player.getName() + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
    }

    public void printDealerDrew() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public void printParticipantDeck(Dealer dealer, Players players) {
        printDealerDeck(dealer);
        for (Player player : players.getPlayers()) {
            printPlayerDeck(player);
        }
    }

    private void printDealerDeck(Dealer dealer) {
        String deck = dealer.getDeck().toString();
        deck = deck.substring(1, deck.length() - 1);
        System.out.println(dealer.getName() + " 카드: " + deck + " = 결과: "+ dealer.getSum());
    }

    private void printPlayerDeck(Player player) {
        String deck = player.getDeck().toString();
        deck = deck.substring(1, deck.length() - 1);
        System.out.println(player.getName() + "카드: " + deck + " = 결과: " + player.getSum());
    }

    public void printParticipantResult(Dealer dealer, Players players) {
        System.out.println("## 최종 승패");
        printDealerResult(dealer);
        for (Player player : players.getPlayers()) {
            printPlayerResult(player);
        }
    }

    private void printDealerResult(Dealer dealer) {
        sb = new StringBuilder();
        Result result = dealer.getResult();
        sb.append(printWin(result.getWin()));
        sb.append(printDrew(result.getDrew()));
        sb.append(printLose(result.getLose()));
        System.out.println(dealer.getName()+": " + result);
    }

    private void printPlayerResult(Player player) {
        sb = new StringBuilder();
        Result result = player.getResult();
        sb.append(printWin(result.getWin()));
        sb.append(printDrew(result.getDrew()));
        sb.append(printLose(result.getLose()));
        System.out.println(player.getName() + ": " + result);
    }

    private String printWin(int winNumber) {
        if (winNumber == 0) {
            return " ";
        }
        return winNumber + "승 ";
    }

    private String printDrew(int drewNumber) {
        if (drewNumber == 0) {
            return " ";
        }
        return "무 ";
    }

    private String printLose(int loseNumber) {
        if (loseNumber == 0) {
            return " ";
        }
        return "패 ";
    }
}
