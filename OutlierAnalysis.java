import java.util.*;
import java.util.stream.Collectors;

/** Provides outlier detection utilities for attack-power values */
public class OutlierAnalysis {

    public static Map<String, Long> analyze(List<ChthonicCreature> list) {

        List<Double> values = list.stream()
                .map(ChthonicCreature::getAttackPower)
                .sorted()
                .toList();

        double q1 = values.get(values.size() / 4);
        double q3 = values.get(values.size() * 3 / 4);
        double iqr = q3 - q1;

        double lower = q1 - 1.5 * iqr;
        double upper = q3 + 1.5 * iqr;

        return list.stream()
                .collect(Collectors.groupingBy(
                        c -> (c.getAttackPower() < lower
                                || c.getAttackPower() > upper)
                                ? "outliers"
                                : "data",
                        Collectors.counting()
                ));
    }
}
