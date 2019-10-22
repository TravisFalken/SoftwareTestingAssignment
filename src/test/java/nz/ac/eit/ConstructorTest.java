package nz.ac.eit;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class ConstructorTest {
    private Player player;
    private Die die;
    private Game game;
    private Dealer dealer;

    @Test
    public void playerTest_Construction_True() {
        player = new Player("Timmy Turner");
        assertThat("Player class is being made and not returning true", player, instanceOf(Player.class));
    }

    @Test
    public void dieTest_Construction_True() {
        die = new Die();
        assertThat("Die class is being made and not returning true", die, instanceOf(Die.class));
    }

    @Test
    public void gameTest_Construction_True() {
        game = new Game();
        assertThat("Game class is being made and not returning true", game, instanceOf(Game.class));
    }

    @Test
    public void dealerTest_Construction_True() {
        dealer = new Dealer();
        assertThat("Dealer class is being made and not returning true", dealer, instanceOf(Dealer.class));
    }
}
