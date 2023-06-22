import controller.Controller;
import domain.CardDeck;
import domain.Referee;

public class BlackJack {

    public static void main(String[] args) {
        Controller controller = new Controller(CardDeck.create(), new Referee());
        controller.start();
    }
}

