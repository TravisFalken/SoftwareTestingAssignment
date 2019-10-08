package nz.ac.eit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    private Player player;

    @Before
    public void setup() {
        player = new Player("Peter Parker");
    }

    @Test
    public void playerTest_GetUserName_GetsInputUserName() {
        boolean result = player.getUserName().equals("Peter Parker");
        assertEquals("Given username is not being set", true, result);
    }

    @Test
    public void playerTest_SetUserName_IfEmptyInputSetToDefaultUsername() {
        player.setUserName("");
        boolean result = player.getUserName().equals("Player 1");
        assertEquals("Empty string does not set username to default username (Player 1)", true, result);
    }
}
