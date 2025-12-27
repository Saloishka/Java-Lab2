/** Gatherer interface used by Streams.gather */
public interface Gatherer<T, S, R> {
    S supplier();
    boolean accumulate(S state, T element);
    R finish(S state);
}
