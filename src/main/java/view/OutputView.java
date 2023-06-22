package view;

import dto.DeckAndSumResponse;
import dto.DeckResponse;
import dto.CardResponse;
import dto.NameResponse;
import dto.ResultResponse;
import java.util.ArrayList;
import static org.apache.commons.lang3.StringUtils.join;

public class OutputView {

    private static final String COMMA = ", ";
    private static final String COLONS = ": ";
    private static final String HYPHEN = " -";
    private static final String CARD = " 카드";
    private static final String RESULT = " 결과 ";
    private static final String PROFIT_PHASE = "## 최종 수익";

    public void askName() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉽표 기준으로 분리)");
    }

    public void askBettingAmount(final NameResponse nameResponse) {
        System.out.println(nameResponse.getName() + "의 배팅 금액은?");
    }

    public void askGetMoreCard(final NameResponse nameResponse) {
        System.out.println(nameResponse.getName() + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
    }

    public void printDealerDrew() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public void printCard(final CardResponse cardResponse) {
        System.out.println(cardResponse.getName() + COLONS + cardResponse.getValue());
    }

    public void printDeck(final DeckResponse deckResponseDto) {
        ArrayList<String> playerCards = new ArrayList<>();
        deckResponseDto.getDeck().forEach(card -> playerCards.add(card.getValueAndShape()));
        System.out.println(deckResponseDto.getName() + COLONS + join(playerCards, COMMA));
    }

    public void printDeckAndSum(final DeckAndSumResponse deckAndSumResponse) {
        ArrayList<String> dealerCards = new ArrayList<>();
        deckAndSumResponse.getDeck().forEach(card -> dealerCards.add(card.getValueAndShape()));
        System.out.println(deckAndSumResponse.getName() + CARD + COLONS + join(dealerCards, COMMA)
                + HYPHEN + RESULT + COLONS + deckAndSumResponse.getSum());
    }

    public void printResult(final ResultResponse resultResponse) {
        System.out.println(resultResponse.getName() + COLONS + resultResponse.getProfit());
    }

    public void printResultPhase() {
        System.out.println(PROFIT_PHASE);
    }

    public void printOneLineJump() {
        System.out.println();
    }
}
