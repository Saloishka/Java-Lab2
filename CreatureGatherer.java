import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/** Gatherer implementations for collecting creatures from streams */
public final class CreatureGatherer {
    public static Gatherer<ChthonicCreature, State, List<ChthonicCreature>>
    skipAndCollect(int skipCount, Predicate<ChthonicCreature> condition) {

        return new Gatherer<>() {
            @Override
            public State supplier() {
                return new State(skipCount);
            }

            @Override
            public boolean accumulate(State state, ChthonicCreature element) {
                if (condition.test(element) && state.toSkip > 0) {
                    state.toSkip--;
                    return true;
                }
                if (state.collected.size() < 500) {
                    state.collected.add(element);
                    return true;
                }
                return false; 
            }

            @Override
            public List<ChthonicCreature> finish(State state) {
                return state.collected;
            }
        };
    }

    /** Internal state used by skipAndCollect to track skipping and collected elements */
    private static class State {
        int toSkip;
        List<ChthonicCreature> collected = new ArrayList<>();

        State(int toSkip) {
            this.toSkip = toSkip;
        }
    }
}
