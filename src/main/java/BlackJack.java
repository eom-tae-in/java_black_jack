import controller.Controller;
import domain.CardDeck;
import domain.Referee;
import view.InputView;
import view.OutputView;

public class BlackJack {

    public static void main(String[] args) {
        Controller controller = new Controller(CardDeck.create(), new Referee(), new OutputView(), new InputView());
        controller.start();
    }
}

