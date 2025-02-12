package service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhaseGameTest {

    PhaseGame phaseGame = new PhaseGame(1);

    @Test
    public void testStartGame() {

    }

    @Test
    public void testNextPhase() {
        phaseGame.nextPhase();

        assertEquals(3, phaseGame.getCurrentPhase());
    }

    @Test
    public void testLosePhase() {
        phaseGame.losePhase();
        assertEquals(0, phaseGame.getCurrentPhase());
    }

    @Test
    public void testReviewPhase() {
        phaseGame.reviewPhase();
        assertEquals(1, phaseGame.getCurrentPhase());
    }

    @Test
    public void testRestartPhase() {
        phaseGame.restartPhase();
        assertEquals(2, phaseGame.getCurrentPhase());
    }
}