import java.util.Iterator;
import java.util.stream.Stream;

/**  Methods for working with Streams */
public final class Streams {
    private Streams() {}

    public static <T, S, R> R gather(Stream<T> stream, Gatherer<T, S, R> gatherer) {
        try (Stream<T> s = stream) {
            S state = gatherer.supplier();
            Iterator<T> it = s.iterator();
            while (it.hasNext()) {
                T e = it.next();
                boolean cont = gatherer.accumulate(state, e);
                if (!cont) break;
            }
            return gatherer.finish(state);
        }
    }
}
