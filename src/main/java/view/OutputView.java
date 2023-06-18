package view;

import dto.DeckAndSumResponseDto;
import dto.DeckResponseDto;
import dto.OnlyOneCardResponseDto;
import dto.ResultResponseDto;
import java.util.ArrayList;
import static org.apache.commons.lang3.StringUtils.join;

public class OutputView {

    private static final String COMMA = ", ";
    private static final String COLONS = ": ";
    private static final String HYPHEN = " -";
    private static final String CARD = " 카드";
    private static final String RESULT = " 결과 ";
    private static final String RESULT_PHASE = "## 최종 승패";

    public void askName() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉽표 기준으로 분리)");
    }

    public void askMore(String name) {
        System.out.println(name + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
    }

    public void printDealerDrew() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public void printOnlyOneCard(OnlyOneCardResponseDto onlyOneCardResponseDto) {
        System.out.println(onlyOneCardResponseDto.getName() + COLONS + onlyOneCardResponseDto.getValue());
    }

    public void printDeck(DeckResponseDto deckResponseDto) {
        ArrayList<String> playerCards = new ArrayList<>();
        deckResponseDto.getDeck().forEach(card -> playerCards.add(card.getValueAndShape()));
        System.out.println(deckResponseDto.getName() + COLONS + join(playerCards, COMMA));
    }



    public void printDeckAndSum(DeckAndSumResponseDto deckAndSumResponseDto) {
        ArrayList<String> dealerCards = new ArrayList<>();
        deckAndSumResponseDto.getDeck().forEach(card -> dealerCards.add(card.getValueAndShape()));
        System.out.println(deckAndSumResponseDto.getName() + CARD + COLONS + join(dealerCards, COMMA)
                + HYPHEN + RESULT + COLONS + deckAndSumResponseDto.getSum());
    }


    public void printResult(ResultResponseDto resultResponseDto) {
        System.out.println(resultResponseDto.getName() + COLONS + resultResponseDto.getResult());
    }

    public void printResultPhase() {
        System.out.println(RESULT_PHASE);
    }

    public void printOneLineJump() {
        System.out.println();
    }
}
