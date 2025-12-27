import java.util.List;
import java.util.Map;

/**  Generates creatures, performs analysis and prints statistics. */
public class Main {

    public static void main(String[] args) {

        int N = 10;

        List<ChthonicCreature> creatures =
                Streams.gather(
                        CreatureGenerator.infiniteStream(),
                        CreatureGatherer.skipAndCollect(
                                N,
                                c -> "демон".equals(c.getSpecies())
                        )
                );

        Map<String, List<ChthonicCreature>> grouped =
                CreatureAnalysis.filterAndGroup(creatures, 200, 1500);

        AttackStats stats = creatures.stream()
                .collect(AttackStatsCollector.collector());
        System.out.println("Min attack: " + stats.min);
        System.out.println("Max attack: " + stats.max);
        System.out.println("Mean attack: " + stats.mean());
        System.out.println("Std deviation: " + stats.stdDeviation());
        System.out.println(OutlierAnalysis.analyze(creatures));
    }
}
