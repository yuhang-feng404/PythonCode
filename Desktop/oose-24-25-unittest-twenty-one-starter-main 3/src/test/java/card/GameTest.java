package card;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import java.util.ArrayList;

import card.entity.PlayerType;
import card.entity.Player;
import card.Game;

public class GameTest {

    private Game game = new Game() {
        @Override
        protected void beforePlayOfRound() {

        }

        @Override
        protected void afterPlayOfRound() {

        }

        @Override
        protected void userPlays(Player player) {

        }

        @Override
        protected void computerPlays(Player player) {

        }

        @Override
        protected void initiate() {

        }
    };

    @Test
    void testAddPlayerCount() {
        Player player = new Player(PlayerType.USER, "Derek");
        game.addPlayer(player);
        assertEquals(1, game.getPlayersSize());
    }

    @Test
    void testAddPlayerName() {
        String name = "Alice";
        Player player = new Player(PlayerType.USER, name);
        game.addPlayer(player);
        assertEquals(name, game.getPlayer(Game.USER_INDEX).getName());
    }

    @Test
    void testClearPlayers() {
        Player player = new Player(PlayerType.USER, "Bob");
        game.addPlayer(player);
        game.clearPlayers();
        assertEquals(0, game.getPlayersSize());
    }

    @Test
    void testCreatePlayerCount() {
        game.createPlayer(PlayerType.USER, "Charlie");
        assertEquals(1, game.getPlayersSize());
    }

    @Test
    void testCreatePlayerName() {
        String name = "David";
        game.createPlayer(PlayerType.USER, name);
        assertEquals(name, game.getPlayer(Game.USER_INDEX).getName());
    }

    @Test
    void testCreateHumanPlayer() {
        String name = "Eve";
        game.createHumanPlayer(name);
        assertEquals(name, game.getPlayer(Game.USER_INDEX).getName());
    }

    @Test
    void testGetNextComputerNameFirst() {
        List<String> names = new ArrayList<>(List.of("AI-1", "AI-2", "AI-3")); // Use modifiable list
        assertEquals("AI-1", game.getNextComputerName(names));
    }

    @Test
    void testGetNextComputerNameSecond() {
        List<String> names = new ArrayList<>(List.of("AI-1", "AI-2", "AI-3"));
        game.getNextComputerName(names);
        assertEquals("AI-2", game.getNextComputerName(names));
    }

    @Test
    void testInitiatePlayers() {
        game.initiatePlayers(3, "AI-");
        assertEquals(3, game.getPlayersSize());
    }

    @Test
    void testInitiatePlayersComputer() {
        game.initiatePlayers(3, "AI-");
        assertEquals(PlayerType.COMPUTER, game.getPlayer(1).getCompetitorType());
    }

    @Test
    void testResetPlayers() {
        game.initiatePlayers(3, "AI-");
        game.resetPlayers();
        assertFalse(game.getUser().hasWon());
    }

    @Test
    void testDetermineWinnerByScoreDecrease() {
        game.clearPlayers();
        Player p1 = new Player(PlayerType.USER, "User");
        Player p2 = new Player(PlayerType.COMPUTER, "AI-1");
        Player p3 = new Player(PlayerType.COMPUTER, "AI-2");
        game.addPlayer(p1);
        game.addPlayer(p2);
        game.addPlayer(p3);
        p1.setScore(30);
        p2.setScore(20);
        p3.setScore(10);
        Player winner = game.determineWinner();
        assertEquals(p1, winner);
    }

    @Test
    void testDetermineWinnerByScoreIncrease() {
        game.clearPlayers();
        Player p1 = new Player(PlayerType.USER, "User");
        Player p2 = new Player(PlayerType.COMPUTER, "AI-1");
        Player p3 = new Player(PlayerType.COMPUTER, "AI-2");
        game.addPlayer(p1);
        game.addPlayer(p2);
        game.addPlayer(p3);
        p1.setScore(10);
        p2.setScore(20);
        p3.setScore(30);
        Player winner = game.determineWinner();
        assertEquals(p3, winner);
    }

    @Test
    void testDetermineWinnerByScoreDecreaseWithWinner() {
        Player p1 = new Player(PlayerType.USER, "User");
        Player p2 = new Player(PlayerType.COMPUTER, "AI-1");
        Player p3 = new Player(PlayerType.COMPUTER, "AI-2");
        game.addPlayer(p1);
        game.addPlayer(p2);
        game.addPlayer(p3);
        p1.setScore(10);
        p2.setScore(20);
        p3.setScore(30);
        Player winner = game.determineWinner();
        assertEquals(p3, winner);
    }

    @Test
    void testDetermineWinnerByScoreIncreaseWithWInner() {
        game.clearPlayers();
        Player p1 = new Player(PlayerType.USER, "User");
        Player p2 = new Player(PlayerType.COMPUTER, "AI-1");
        Player p3 = new Player(PlayerType.COMPUTER, "AI-2");
        game.addPlayer(p1);
        game.addPlayer(p2);
        game.addPlayer(p3);
        p1.setScore(30);
        p2.setScore(20);
        p3.setScore(10);
        Player winner = game.determineWinner();
        assertEquals(p1, winner);
    }

    @Test
    void testSetFinishGame() {
    }
}
