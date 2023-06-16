import controller.Controller;
import domain.CardDeck;
import domain.Referee;
import view.InputView;
import view.OutputView;

public class BlackJack {

    public static void main(String[] args) {
        Controller controller = new Controller(new InputView(), new OutputView(), CardDeck.create(), new Referee());
        controller.start();
    }
}

