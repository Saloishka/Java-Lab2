import java.util.stream.Collector;

/** Provides a Collector to accumulate attack-power statistics into an AttackStats instance */
public class AttackStatsCollector {
    public static Collector<ChthonicCreature, AttackStats, AttackStats> collector() {
        return Collector.of(
                AttackStats::new,
                (stats, c) -> stats.accept(c.getAttackPower()),
                (a, b) -> {
                    a.combine(b);
                    return a;
                }
        );
    }
}
