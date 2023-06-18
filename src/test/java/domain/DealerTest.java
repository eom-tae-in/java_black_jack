//package domain;
//
//import dto.RefereeResultResponseDto;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class DealerTest {
//
//    private Dealer dealer;
//
//    @BeforeEach
//    void initData() {
//        dealer = new Dealer(new Name("딜러"), new RefereeResultResponseDto(0, 0, 0), new ParticipantDeck());
//    }
//
//    @Test
//    @DisplayName("딜러의 카드 숫자 합이 16이하면 true를 반환한다.")
//    void isMoreCardTest_True() {
//        //given
//        dealer.drawCard(new Card(new Shape("다이아몬드"), new Value("6", 6)));
//        dealer.drawCard(new Card(new Shape("다이아몬드"), new Value("8", 8)));
//
//        //when
//        boolean result = dealer.isMoreCard();
//
//        //then
//        assertThat(result).isTrue();
//    }
//
//    @Test
//    @DisplayName("딜러의 카드 숫자 합이 17이상이면 false를 반환한다.")
//    void isMOreCardTest_False() {
//        //given
//        dealer.drawCard(new Card(new Shape("다이아몬드"), new Value("J", 10)));
//        dealer.drawCard(new Card(new Shape("다이아몬드"), new Value("K", 10)));
//
//        //when
//        boolean result = dealer.isMoreCard();
//
//        //then
//        assertThat(result).isFalse();
//    }
//
//    @Test
//    @DisplayName("딜러의 카드 중 가장 먼저 뽑은 한 장의 카드만 반환한다.")
//    void showOnlyOneTest() {
//        //given
//        dealer.drawCard(new Card(new Shape("다이아몬드"), new Value("4", 4)));
//        dealer.drawCard(new Card(new Shape("하트"), new Value("9", 9)));
//
//        //when
//        Card card = dealer.showOnlyOne();
//
//        //then
//        assertThat(card.getNumber()).isEqualTo(4);
//        assertThat(card.getValue()).isEqualTo("4");
//        assertThat(card.getValueAndShape()).isEqualTo("4다이아몬드");
//    }
//}
