package controller;

import domain.*;
import dto.*;
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
        return new Dealer(new Name(DEALER), new ParticipantDeck(), new Results());
    }

    public Players getPlayers() {
        outputView.askName();
        String[] playerNames = inputView.getName();
        ArrayList<Player> players = new ArrayList<>();
        Arrays.stream(playerNames).forEach(player -> players.add(new Player(new Name(player), new ParticipantDeck())));
        outputView.printOneLineJump();
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
        outputView.printOnlyOneCard(OnlyOneCardResponseDto.toDto(dealer));
        for (Player player : players.getPlayers()) {
            outputView.printDeck(DeckResponseDto.toDto(player));
        }
        outputView.printOneLineJump();
    }

    public void getMoreCard(Dealer dealer, Players players) {
        for (Player player : players.getPlayers()) {
            checkMoreCard(player);
        }
        outputView.printOneLineJump();
        getDealerMoreCard(dealer);
        outputView.printOneLineJump();
    }

    public void checkMoreCard(Player player) {
        while (!player.isGameOver() && Answer.isYes(askGetMore(player.getName()))) {
            player.drawCard(cardDeck.draw());
            outputView.printDeck(DeckResponseDto.toDto(player));
        }
    }

    public void getDealerMoreCard(Dealer dealer) {
        while (dealer.isMoreCard()) {
            outputView.printDealerDrew();
            dealer.drawCard(cardDeck.draw());
        }
    }

    private String askGetMore(String name) {
        outputView.askMore(name);
        return inputView.getMore();
    }

    public void showDeckWithSum(Dealer dealer, Players players) {
        outputView.printDeckAndSum(DeckAndSumResponseDto.toDto(dealer));
        for (Player player : players.getPlayers()) {
            outputView.printDeckAndSum(DeckAndSumResponseDto.toDto(player));
        }
        outputView.printOneLineJump();
    }

    public void decideResult(Dealer dealer, Players players) {
        for (Player player : players.getPlayers()) {
            RefereeResultResponseDto refereeResultResponseDto = referee.decideResult(dealer.getSum(), player.getSum());
            player.addResult(refereeResultResponseDto.getPlayerResult());
            dealer.addResult(refereeResultResponseDto.getDealerResult());
        }
    }

    public void showResult(Dealer dealer, Players players) {
        outputView.printResultPhase();
        outputView.printResult(ResultResponseDto.toDto(dealer));
        for (Player player : players.getPlayers()) {
            outputView.printResult(ResultResponseDto.toDto(player));
        }
    }
}
