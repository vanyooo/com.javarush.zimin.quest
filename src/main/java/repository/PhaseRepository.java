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
            new Phase("Вы – капитан исследовательского судна \"Морской Странник\"." +
                    " Ваш экипаж отправился в экспедицию к неизведанным глубинам Тихого океана," +
                    " но сильный шторм сбил вас с курса. Радиосвязь нарушена, а приборы показывают странные помехи. " +
                    "На горизонте темнеет грозовое небо, а под килем радар фиксирует нечто гигантское. " +
                    "Единственный путь – вперёд. ",
                    List.of(new Answer(1, "Продолжить"),
                            new Answer(5, "Выбрать другой квест"))),
            new Phase("Радиоприёмник улавливает старый маяк - слабый сигнал SOS, " +
                    "исходящий с неизвестного острова. Это может быть чей-то крик о помощи... или ловушка",
                    List.of(new Answer(1, "Повернуть к острову – возможно, " +
                                    "там есть выжившие или ценные ресурсы."),
                            new Answer(2, "Игнорировать сигнал и плыть дальше"))),
            new Phase("Оказавшись на острове, вы замечаете заброшенные рыбацкие хижины. " +
                    "Всё покрыто ржавчиной и водорослями, будто остров давно забыт." +
                    " Однако кострище в центре деревни ещё теплится. Вдруг из тумана доносится шёпот...,",
                    List.of(new Answer(1, "Исследовать деревню – возможно, кто-то здесь всё же остался... "),
                            new Answer(2, "Вернуться на корабль и уплыть – но как только вы поднимаете якорь," +
                                    " из глубин появляются гигантские щупальца.."))),
            new Phase("Вы находите артефакт, спрятанный в древнем храме. Когда вы берёте его в руки, компас начинает светиться, и море вокруг острова успокаивается.\n" +
                    "\n" +
                    "Старик благодарит вас и говорит:\n" +
                    "\"Теперь ты сможешь найти дорогу домой. Этот компас ведёт лишь тех, кто верит в своё сердце.\"\n" +
                    "\n" +
                    "Вы возвращаетесь на корабль. Артефакт действительно указывает безопасный маршрут, " +
                    "минуя аномалии. Через несколько часов вы выходите на связь с берегом и возвращаетесь домой," +
                    " неся с собой тайну проклятого острова.",
                    List.of(new Answer(3, "Ура!!!! Победа "),
                            new Answer(4, "Играть заново!")))
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
