package nz.ac.eit;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DealerTest {
    private Dealer dealer;

    @Before
    public void setup() {
        dealer = new Dealer();
    }

    @Test
    public void dealerTest_CanBet_True() {
        dealer.setHandValue(14);
        boolean result = dealer.canBet();
        assertEquals("Hand value is less than 16(house limit) and is not returning true", true, result);
    }

    @Test
    public void dealerTest_CanBet_False() {
        dealer.setHandValue(20);
        boolean result = dealer.canBet();
        assertEquals("Hand value is more than 16(house limit) and is not returning false", false, result);
    }
}
