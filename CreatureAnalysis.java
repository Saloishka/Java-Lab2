import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Analysis utilities: filtering creatures by years-known and grouping them by creature type.
 */
public class CreatureAnalysis {
    /**
     * Filter list by yearsKnown range and group by creatureType
     *
     * @param list      the list of ChthonicCreature
     * @param minYears  the minimum years known
     * @param maxYears  the maximum years known
     * @return          a map where the key is the creature type and the value is the list of creatures
     */
    public static Map<String, List<ChthonicCreature>> filterAndGroup(
            List<ChthonicCreature> list,
            int minYears,
            int maxYears) {

        return list.stream()
                .filter(c -> c.getYearsKnown() >= minYears
                        && c.getYearsKnown() <= maxYears)
                .collect(Collectors.groupingBy(
                        ChthonicCreature::getCreatureType));
    }
}
