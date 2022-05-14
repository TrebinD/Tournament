import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game = new Game();
    Player playerFirst = new Player(1, "Vasia", 1);
    Player playerSecond = new Player(2, "Petiya", 3);
    Player playerThird = new Player(4, "Nikita", 3);

    @Test
    public void add() {
        game.register(playerFirst);
        game.register(playerSecond);

        Player[] expected = {playerFirst, playerSecond};
        Player[] actual = game.findAll().toArray(new Player[0]);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void roundDrow() {
        game.register(playerThird);
        game.register(playerSecond);
        int expected = 0;
        int actual = game.round("Nikita", "Petiya");

        assertEquals(expected, actual);
    }

    @Test
    public void roundFirstdWin() {
        game.register(playerSecond);
        game.register(playerFirst);
        int expected = 2;
        int actual = game.round("Vasia", "Petiya");

        assertEquals(expected, actual);
    }

    @Test
    public void roundSecondWin() {
        game.register(playerFirst);
        game.register(playerSecond);
        int expected = 1;
        int actual = game.round("Petiya", "Vasia");

        assertEquals(expected, actual);
    }

    @Test
    public void onePlayerNoRegistered() {
        game.register(playerFirst);
        game.register(playerSecond);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Petiya", "Djon");
        });
    }

    @Test
    public void twoPlayerNoRegistered() {
        game.register(playerFirst);
        game.register(playerSecond);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Sonia", "Djon");
        });
    }

    @Test
    public void onePlayerNoRegisteredChange() {
        game.register(playerFirst);
        game.register(playerSecond);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Sonia", "Petiya");
        });
    }


}