package controller;

import domain.CardDeck;
import domain.Referee;
import domain.Player;
import domain.Players;
import domain.Dealer;
import domain.Answer;
import dto.ResultDto;
import domain.ParticipantDeck;
import domain.Name;
import view.InputView;
import view.OutputView;
import java.util.ArrayList;
import java.util.Arrays;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private final CardDeck cardDeck;
    private final Referee referee;

    private static final String DEALER = "딜러";
    private static final int INITIAL_VALUE = 0;

    public Controller(InputView inputView, OutputView outputView, CardDeck cardDeck, Referee referee) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.cardDeck = cardDeck;
        this.referee = referee;
    }

    public void start() {
        Players players = getPlayers();
        Dealer dealer = getDealer();
        firstDraw(dealer, players);
        showFirstDeck(dealer, players);
        getMoreCard(dealer, players);
        showDeckWithSum(dealer, players);
        decideResult(dealer, players);
        showResult(dealer, players);
    }

    public Dealer getDealer() {
        return new Dealer(new Name(DEALER), new ResultDto(INITIAL_VALUE, INITIAL_VALUE, INITIAL_VALUE), new ParticipantDeck());
    }

    public Players getPlayers() {
        outputView.askName();
        String[] playerNames = inputView.getName();
        ArrayList<Player> players = new ArrayList<>();
        Arrays.stream(playerNames).forEach(player -> players.add(new Player(new Name(player),
                new ResultDto(INITIAL_VALUE, INITIAL_VALUE, INITIAL_VALUE), new ParticipantDeck())));
        return new Players(players);
    }

    public void firstDraw(Dealer dealer, Players players) {
        dealer.drawCard(cardDeck.draw());
        dealer.drawCard(cardDeck.draw());
        for (Player player : players.getPlayers()) {
            player.drawCard(cardDeck.draw());
            player.drawCard(cardDeck.draw());
        }
    }

    public void showFirstDeck(Dealer dealer, Players players) {
        outputView.printFirstDeck(dealer, players);
    }

    public void getMoreCard(Dealer dealer, Players players) {
        getPlayersMoreCard(players);
        getDealerMoreCard(dealer);
    }

    public void getPlayersMoreCard(Players players) {
        for (Player player : players.getPlayers()) {
            checkMoreCard(player);
        }
    }


    public void checkMoreCard(Player player) {
        askGetMore(player);
        while (Answer.isYes(player.getAnswer())) {
            player.drawCard(cardDeck.draw());
            outputView.printPlayerDeck(player);
            askGetMore(player);
        }
    }

    private void askGetMore(Player player) {
        outputView.askMore(player.getName());
        player.setAnswer(inputView.getMore());
    }

    public void getDealerMoreCard(Dealer dealer) {
        while (dealer.isMoreCard()) {
            outputView.printDealerDrew();
            dealer.drawCard(cardDeck.draw());
        }
    }

    public void showDeckWithSum(Dealer dealer, Players players) {
        outputView.printTotalDeck(dealer, players);
    }

    public void decideResult(Dealer dealer, Players players) {
        for (Player player : players.getPlayers()) {
            referee.decideResult(player, dealer);
        }
    }

    public void showResult(Dealer dealer, Players players) {
        outputView.printResult(dealer, players);
    }
}
