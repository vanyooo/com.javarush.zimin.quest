package repository;


import entity.Phase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PhaseRepositoryTest {

    private PhaseRepository repository;

    @BeforeEach
    public void setUp() {
        repository = PhaseRepository.getInstance();
    }

    @Test
    public void testSingletonInstance() {
        PhaseRepository anotherInstance = PhaseRepository.getInstance();
        assertSame(repository, anotherInstance);
    }

    @Test
    void testGetNonExistentQuestReturnsNull() {
        List<Phase> quest = repository.getAllPhases(99);
        assertNull(quest, "Запрос несуществующего квеста должен возвращать null");
    }

    @Test
    void testInitialQuestsAreLoaded() {
        List<Phase> quest1 = repository.getAllPhases(1);
        List<Phase> quest2 = repository.getAllPhases(2);

        assertNotNull(quest1, "Квест 1 должен быть загружен");
        assertNotNull(quest2, "Квест 2 должен быть загружен");
        assertFalse(quest1.isEmpty(), "Квест 1 не должен быть пустым");
        assertFalse(quest2.isEmpty(), "Квест 2 не должен быть пустым");
    }
}