import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Generates an infinite stream of ChthonicCreature instances with randomized attributes
 */
public final class CreatureGenerator {

    private static final Random RANDOM = new Random();
    private static final List<String> NAMES =
            List.of("Азазель", "Ліліт", "Вій", "Мара", "Чугайстер", "Леший");
    private static final List<String> SPECIES =
            List.of("демон", "дух", "мертва істота", "напівбог");
    private static final List<String> TYPES =
            List.of("агресивна", "нейтральна", "хаотична");
    private CreatureGenerator() {
    }

    public static Stream<ChthonicCreature> infiniteStream() {
        return Stream.generate(() ->
                new ChthonicCreature(
                        NAMES.get(RANDOM.nextInt(NAMES.size())),
                        SPECIES.get(RANDOM.nextInt(SPECIES.size())),
                        50 + RANDOM.nextInt(2000),
                        TYPES.get(RANDOM.nextInt(TYPES.size())),
                        10 + RANDOM.nextDouble() * 90
                ));
    }
}
