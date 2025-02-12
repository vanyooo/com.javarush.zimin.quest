package repository;

import entity.Answer;
import entity.Phase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class PhaseRepository {

    private Map<Integer, List<Phase>> map = new HashMap<>();

    private final List<Phase> questionList = List.of(new Phase("\uD83D\uDC80 Очень жаль... \uD83D\uDC80" +
                    "Ты проиграл... ",
                    List.of(new Answer(3, "Увы!!!! Я проиграл"),
                            new Answer(4, "Попробую еще раз!"))),
            new Phase("Пожалуйста, оставте отзыв об игре",
                    List.of(new Answer(4, "Все понравилось"),
                            new Answer(4, "Не очень"))),
            new Phase("Вы – пилот исследовательского корабля \"Аврора-7\"." +
                    " После сбоя навигации ваш корабль оказался в неизвестной части галактики." +
                    " Топливо на исходе, системы работают нестабильно.\n" +
                    "    Единственный выход – найти путь домой.", List.of(new Answer(1, "Продолжить"),
                    new Answer(5, "Выбрать другой квест"))),
            new Phase("На радаре появляется слабый сигнал бедствия." +
                    " Это может быть шанс на спасение или смертельная ловушка.",
                    List.of(new Answer(1, "Принять сигнал и лететь к его источнику"),
                            new Answer(2, "Игнорировать сигнал и попытаться двигаться дальше"))),
            new Phase("Вы прибываете на источник сигнала и обнаруживаете заброшенный корабль древней цивилизации." +
                    "Датчики показывают следы активности внутри.",
                    List.of(new Answer(1, "Зайти внутрь и исследовать корабль"),
                            new Answer(2, "Испугаться, и остаться на своём корабле"))),
            new Phase("На корабле есть всё необходимое для ремонта систем навигации," +
                    " а также топливо для поездки домой. Вы победили!!!",
                    List.of(new Answer(3, "Ура!!!! Я победил"),
                            new Answer(4, "Играть заново!")))

    );
    private final List<Phase> questionList2 = List.of(new Phase("\uD83D\uDC80 Очень жаль... \uD83D\uDC80" +
                    "Ты проиграл... ",
                    List.of(new Answer(3, "Увы!!!! Я проиграл"),
                            new Answer(4, "Попробую еще раз!"))),
            new Phase("Пожалуйста, оставте отзыв об игре",
                    List.of(new Answer(4, "Все понравилось"),
                            new Answer(4, "Не очень"))),
            new Phase("Тут какой-то вопрос" +
                    "и небольшая история ",
                    List.of(new Answer(1, "1 вариант ответа"),
                            new Answer(2, "2 вариант ответа"))),
            new Phase("Тут сообщение о победе" +
                    "и небольшая история ",
                    List.of(new Answer(3, "1 вариант ответа"),
                            new Answer(4, "2 вариант ответа")))
    );

    private static PhaseRepository instance;

    private PhaseRepository() {
        addStartQuest();
    }

    public void addStartQuest() {
        map.put(1, questionList);
        map.put(2, questionList2);
    }

    public static PhaseRepository getInstance() {
        if (instance == null) {
            instance = new PhaseRepository();
        }
        return instance;
    }

    public List<Phase> getAllPhases(int number) {
        return map.get(number);
    }

    public Map<Integer, List<Phase>> getAllQuest() {
        return map;
    }

    public void addQuest(List<Phase> phases) {
        List<Phase> questionList3 = new ArrayList<>();
        questionList3.add(new Phase("\uD83D\uDC80 Очень жаль... \uD83D\uDC80" +
                "Ты проиграл... ",
                List.of(new Answer(3, "Увы!!!! Я проиграл"),
                        new Answer(4, "Попробую еще раз!"))));
        questionList3.add(new Phase("Пожалуйста, оставте отзыв об игре",
                List.of(new Answer(4, "Все понравилось"),
                        new Answer(4, "Не очень"))));
        questionList3.addAll(phases);
        List<Phase> list = Stream.concat(questionList3.stream(), phases.stream())
                .toList();
        map.put(map.size() + 1, list);
    }
}
