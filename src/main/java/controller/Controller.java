package controller;

import domain.Answer;
import domain.CardDeck;
import domain.Dealer;
import domain.Money;
import domain.Name;
import domain.Deck;
import domain.Player;
import domain.Players;
import domain.Referee;
import domain.Amount;
import dto.DeckAndSumResponse;
import dto.DeckResponse;
import dto.CardResponse;
import dto.NameResponse;
import dto.RefereeResultResponse;
import dto.ResultResponse;
import view.InputView;
import view.OutputView;
import java.util.ArrayList;
import java.util.Arrays;

public class Controller {

    private final CardDeck cardDeck;
    private final Referee referee;
    private final OutputView outputView;
    private final InputView inputView;

    private static final String DEALER = "딜러";

    public Controller(final CardDeck cardDeck, final Referee referee, final OutputView outputView, final InputView inputView) {
        this.cardDeck = cardDeck;
        this.referee = referee;
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        Players players = getPlayers();
        Dealer dealer = getDealer();
        setBettingAmount(players);
        firstDraw(dealer, players);
        showFirstDeck(dealer, players);
        getMoreCard(dealer, players);
        showDeckAndSum(dealer, players);
        decideResult(dealer, players);
        showResult(dealer, players);
    }

    private Players getPlayers() {
        outputView.askName();
        String[] playerNames = inputView.receiveName();
        ArrayList<Player> players = new ArrayList<>();
        Arrays.stream(playerNames)
                .forEach(player -> players.add(new Player(new Name(player), new Deck(), new Money())));
        outputView.printOneLineJump();
        return new Players(players);
    }

    private void setBettingAmount(final Players players) {
        for (Player player : players.getPlayers()) {
            outputView.askBettingAmount(new NameResponse(player.getName()));
            player.setMoney(inputView.receiveMoney());
            outputView.printOneLineJump();
        }
    }

    private Dealer getDealer() {
        return new Dealer(new Name(DEALER), new Deck(), new Amount());
    }

    private void firstDraw(final Dealer dealer, final Players players) {
        dealer.receiveCard(cardDeck.draw());
        dealer.receiveCard(cardDeck.draw());
        for (Player player : players.getPlayers()) {
            player.receiveCard(cardDeck.draw());
            player.receiveCard(cardDeck.draw());
        }
    }

    private void showFirstDeck(final Dealer dealer, final Players players) {
        outputView.printCard(CardResponse.toDto(dealer));
        for (Player player : players.getPlayers()) {
            outputView.printDeck(DeckResponse.toDto(player));
        }
        outputView.printOneLineJump();
    }

    private void getMoreCard(final Dealer dealer, final Players players) {
        for (Player player : players.getPlayers()) {
            askGetMoreCard(player);
        }
        outputView.printOneLineJump();
        checkGetMoreCard(dealer);
        outputView.printOneLineJump();
    }

    private void askGetMoreCard(final Player player) {
        while (canGetMoreCard(player)) {
            player.receiveCard(cardDeck.draw());
            outputView.printDeck(DeckResponse.toDto(player));
        }
    }

    private boolean canGetMoreCard(final Player player) {
        return !player.isGameOver() && Answer.isYes(getAnswer(new NameResponse(player.getName())));
    }


    private void checkGetMoreCard(final Dealer dealer) {
        while (dealer.canGetMoreCard()) {
            dealer.receiveCard(cardDeck.draw());
            outputView.printDealerDrew();
        }
    }

    private String getAnswer(final NameResponse nameResponse) {
        outputView.askGetMoreCard(nameResponse);
        return inputView.receiveAnswer();
    }

    private void decideResult(final Dealer dealer, final Players players) {
        for (Player player : players.getPlayers()) {
            RefereeResultResponse refereeResultResponse = referee.decideResult(dealer.getSum(), player.getSum());
            dealer.changeAmount(refereeResultResponse.getDealerResult(), player.getMoney());
            player.calculateProfitOrLoss(refereeResultResponse.getPlayerResult());
        }
    }

    private void showDeckAndSum(final Dealer dealer, final Players players) {
        outputView.printDeckAndSum(DeckAndSumResponse.toDto(dealer));
        for (Player player : players.getPlayers()) {
            outputView.printDeckAndSum(DeckAndSumResponse.toDto(player));
        }
        outputView.printOneLineJump();
    }

    private void showResult(final Dealer dealer, final Players players) {
        outputView.printResultPhase();
        outputView.printResult(ResultResponse.toDto(dealer));
        for (Player player : players.getPlayers()) {
            outputView.printResult(ResultResponse.toDto(player));
        }
    }
}
