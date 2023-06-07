package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class Controller {

    private final CardDeck cardDeck = new CardDeck();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private static final int DEALER_WIN = 1;
    private static final int DREW = 0;
    private static final int PLAYER_WIN = -1;


    public void start() {
        Players players = new Players();
        Dealer dealer = new Dealer(Participant.Dealer(new UserDeck(), cardDeck));
        outputView.AskName();
        String[] names = inputView.getName();
        cardDeck.ready();
        for (String name : names) {
            players.add(new Player(new Participant(new Name(name), new UserDeck(), cardDeck)));
        }
        firstDraw(dealer, players);
        for (Player player : players.getPlayers()) {
            checkMoreCard(player);
        }
        while (dealer.isMoreCard()) {
            outputView.printDealerDrew();
            dealer.drawCard();
        }
        outputView.printParticipantDeck(dealer, players);
        for (Player player : players.getPlayers()) {
            gameResult(dealer, player);
        }
        outputView.printParticipantResult(dealer, players);
    }

    void firstDraw(Dealer dealer, Players players) {
        dealer.getCard(cardDeck.drawFirst());
        for (Player player : players.getPlayers()) {
            player.getCard(cardDeck.drawFirst());
        }
    }

    void checkMoreCard(Player player) {
        String result = "";
        do {
            outputView.AskMore(player);
            result = inputView.getMore();
            player.drawCard(result);
        } while (result.equals("y"));
    }

    void gameResult(Dealer dealer, Player player) {
        int result = compareNumber(dealer.getSum(), player.getSum());
        if (result == DEALER_WIN) {
            dealerWin(dealer, player);
            return;
        }
        if (result == PLAYER_WIN) {
            playerWin(dealer, player);
            return;
        }
        drew(dealer, player);
    }

    int compareNumber(int dealerSum, int playerSum) {
        // return Integer.compare(dealerSum, playerSum);로 바꿀 수 있음
        if ((dealerSum > playerSum && dealerSum <= 21) || playerSum > 21) {
            return DEALER_WIN;
        }
        if ((dealerSum < playerSum && playerSum <= 21) || dealerSum > 21) {
            return PLAYER_WIN;
        }
        return DREW;
    }

    void dealerWin(Dealer dealer, Player player) {
        dealer.win();
        player.lose();
    }

    void drew(Dealer dealer, Player player) {
        dealer.drew();
        player.drew();
    }

    void playerWin(Dealer dealer, Player player) {
        dealer.lose();
        player.win();
    }
}
