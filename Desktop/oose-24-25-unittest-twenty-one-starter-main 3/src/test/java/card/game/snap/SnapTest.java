package card.game.snap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SnapTest {

    Snap snap = new Snap();

    @Test
    void testDealCards() {
        snap.createComputerCompetitors(4);
        snap.dealCards();
        assertEquals(13, snap.getUser().getHand().size());
    }

    @Test
    void testSnapOverride() {
        Snap snap = new Snap("S3,S4,S5");
        assertEquals(3, snap.getDeck().size());
    }

    @Test
    void testSnapNoOverride() {
        assertEquals(52, snap.getDeck().size());
    }

}
