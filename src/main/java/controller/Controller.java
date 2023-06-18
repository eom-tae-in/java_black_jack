package controller;

import domain.Answer;
import domain.CardDeck;
import domain.Dealer;
import domain.Name;
import domain.ParticipantDeck;
import domain.Player;
import domain.Players;
import domain.Referee;
import domain.Results;
import dto.DeckAndSumResponseDto;
import dto.DeckResponseDto;
import dto.OnlyOneCardResponseDto;
import dto.RefereeResultResponseDto;
import dto.ResultResponseDto;
import view.OutputView;
import java.util.ArrayList;
import java.util.Arrays;
import static view.InputView.receiveAnswer;
import static view.InputView.receiveName;
import static view.OutputView.askName;
import static view.OutputView.printDealerDrew;
import static view.OutputView.printDeck;
import static view.OutputView.printDeckAndSum;
import static view.OutputView.printOneLineJump;
import static view.OutputView.printOnlyOneCard;
import static view.OutputView.printResult;
import static view.OutputView.printResultPhase;

public class Controller {

    private final CardDeck cardDeck;
    private final Referee referee;

    private static final String DEALER = "딜러";

    public Controller(final CardDeck cardDeck, final Referee referee) {
        this.cardDeck = cardDeck;
        this.referee = referee;
    }

    public void start() {
        Players players = getPlayers();
        Dealer dealer = getDealer();
        firstDraw(dealer, players);
        showFirstDeck(dealer, players);
        getMoreCard(dealer, players);
        showDeckAndSum(dealer, players);
        decideResult(dealer, players);
        showResult(dealer, players);
    }

    private Players getPlayers() {
        askName();
        String[] playerNames = receiveName();
        ArrayList<Player> players = new ArrayList<>();
        Arrays.stream(playerNames).forEach(player -> players.add(new Player(new Name(player), new ParticipantDeck())));
        printOneLineJump();
        return new Players(players);
    }

    private Dealer getDealer() {
        return new Dealer(new Name(DEALER), new ParticipantDeck(), new Results());
    }

    private void firstDraw(final Dealer dealer, final Players players) {
        dealer.getCard(cardDeck.draw());
        dealer.getCard(cardDeck.draw());
        for (Player player : players.getPlayers()) {
            player.getCard(cardDeck.draw());
            player.getCard(cardDeck.draw());
        }
    }

    private void showFirstDeck(final Dealer dealer, final Players players) {
        printOnlyOneCard(OnlyOneCardResponseDto.toDto(dealer));
        for (Player player : players.getPlayers()) {
            printDeck(DeckResponseDto.toDto(player));
        }
        printOneLineJump();
    }

    private void getMoreCard(final Dealer dealer, final Players players) {
        for (Player player : players.getPlayers()) {
            askGetMoreCard(player);
        }
        printOneLineJump();
        checkGetMoreCard(dealer);
        printOneLineJump();
    }

    private void askGetMoreCard(final Player player) {
        while (!player.isGameOver() && Answer.isYes(getAnswer(player.getName()))) {
            player.getCard(cardDeck.draw());
            printDeck(DeckResponseDto.toDto(player));
        }
    }

    private void checkGetMoreCard(final Dealer dealer) {
        while (dealer.canGetMoreCard()) {
            dealer.getCard(cardDeck.draw());
            printDealerDrew();
        }
    }

    private String getAnswer(final String player) {
        OutputView.askGetMoreCard(player);
        return receiveAnswer();
    }

    private void decideResult(final Dealer dealer, final Players players) {
        for (Player player : players.getPlayers()) {
            RefereeResultResponseDto refereeResultResponseDto = referee.decideResult(dealer.getSum(), player.getSum());
            player.addResult(refereeResultResponseDto.getPlayerResult());
            dealer.addResult(refereeResultResponseDto.getDealerResult());
        }
    }

    private void showDeckAndSum(final Dealer dealer, final Players players) {
        printDeckAndSum(DeckAndSumResponseDto.toDto(dealer));
        for (Player player : players.getPlayers()) {
            printDeckAndSum(DeckAndSumResponseDto.toDto(player));
        }
        printOneLineJump();
    }

    private void showResult(final Dealer dealer, final Players players) {
        printResultPhase();
        printResult(ResultResponseDto.toDto(dealer));
        for (Player player : players.getPlayers()) {
            printResult(ResultResponseDto.toDto(player));
        }
    }
}
