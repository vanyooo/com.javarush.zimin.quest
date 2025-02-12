package service;

import entity.Phase;
import lombok.Data;
import repository.PhaseRepository;

import java.util.ArrayList;
import java.util.List;

@Data
public class PhaseGame {
    private int currentPhase;
    private List<Phase> questions;

    public PhaseGame(int number) {
        this.currentPhase = 2;
        this.questions = new ArrayList<>();
        loadingPhaseDatabase(number);
    }

    public Phase startGame() {
        return questions.get(currentPhase);
    }

    private void loadingPhaseDatabase(int number) {
        this.questions = PhaseRepository.getInstance().getAllPhases(number);
    }

    public void nextPhase() {
        this.currentPhase++;
    }

    public void losePhase() { this.currentPhase = 0; }

    public void reviewPhase() {this.currentPhase = 1; }

    public void restartPhase() {this.currentPhase = 2; }
}
