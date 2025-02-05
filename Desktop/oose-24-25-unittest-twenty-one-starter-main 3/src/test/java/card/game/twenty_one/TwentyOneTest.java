package card.game.twenty_one;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import card.entity.Hand;
import card.entity.Card;
import card.entity.Player;
import card.entity.PlayerType;

public class TwentyOneTest {

    @Test
    void testComputerPlaysScenario1() {
        TwentyOne game = new TwentyOne();
        Player computer = new Player(PlayerType.COMPUTER, "AI");
        game.computerPlays(computer);
        assertTrue(computer.getHand().size() >= 1);
    }

    @Test
    void testComputerPlaysScenario2() {
        TwentyOne game = new TwentyOne();
        Player computer = new Player(PlayerType.COMPUTER, "AI");
        game.computerPlays(computer);
        assertTrue(computer.getHand().size() >= 0);
    }

    @Test
    void testComputerPlaysScenario3() {
        TwentyOne game = new TwentyOne();
        Player computer = new Player(PlayerType.COMPUTER, "AI");
        game.computerPlays(computer);
        assertNotNull(computer.getHand());
    }

    @Test
    void testScoreHandNoAce() {
        TwentyOne game = new TwentyOne();
        Hand hand = new Hand();
        hand.add(new Card(10));
        hand.add(new Card(5));
        assertEquals(15, game.scoreHand(hand));
    }

    @Test
    void testScoreHandAceUnder21() {
        TwentyOne game = new TwentyOne();
        Hand hand = new Hand();
        hand.add(new Card(11));
        hand.add(new Card(9));
        assertEquals(20, game.scoreHand(hand));
    }

    @Test
    void testScoreHandAceBust() {
        TwentyOne game = new TwentyOne();
        Hand hand = new Hand();
        hand.add(new Card(11));
        hand.add(new Card(10));
        hand.add(new Card(2));
        assertEquals(13, game.scoreHand(hand));
    }
}
