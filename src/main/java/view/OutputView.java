package view;

import domain.*;

public class OutputView {

    private final StringBuilder sb = new StringBuilder();

    public void AskName() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉽표 기준으로 분리)");
    }

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
        sb.setLength(0);
        for (Card card : dealer.getDeck()) {
            sb.append(card.getValue()).append(card.getShape()).append(", ");
        }
        System.out.println(dealer.getName() + " 카드: " + sb + " = 결과: "+ dealer.getSum());
    }

    private void printPlayerDeck(Player player) {
        sb.setLength(0);
        for (Card card : player.getDeck()) {
            sb.append(card.getValue()).append(card.getShape()).append(", ");
        }
        System.out.println(player.getName() + "카드: " + sb + " = 결과: " + player.getSum());
    }

    public void printParticipantResult(Dealer dealer, Players players) {
        System.out.println("## 최종 승패");
        printDealerResult(dealer);
        for (Player player : players.getPlayers()) {
            printPlayerResult(player);
        }
    }

    private void printDealerResult(Dealer dealer) {
        sb.setLength(0);
        Result result = dealer.getResult();
        sb.append(printWin(result.getWin()));
        sb.append(printDrew(result.getDrew()));
        sb.append(printLose(result.getLose()));
        System.out.println(dealer.getName()+": " + sb);
    }

    private void printPlayerResult(Player player) {
        sb.setLength(0);
        Result result = player.getResult();
        sb.append(printWin(result.getWin()));
        sb.append(printDrew(result.getDrew()));
        sb.append(printLose(result.getLose()));
        System.out.println(player.getName() + ": " + sb);
    }

    private String printWin(int winNumber) {
        if (winNumber == 0) {
            return "";
        }
        return winNumber + "승 ";
    }

    private String printDrew(int drewNumber) {
        if (drewNumber == 0) {
            return "";
        }
        return "무 ";
    }

    private String printLose(int loseNumber) {
        if (loseNumber == 0) {
            return "";
        }
        return "패 ";
    }
}
