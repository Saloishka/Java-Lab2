/** Accumulator for basic statistics (min, max, mean, standard deviation) */
public class AttackStats {

    double min = Double.MAX_VALUE;
    double max = Double.MIN_VALUE;
    double sum = 0;
    double sumSquares = 0;
    int count = 0;

    void accept(double value) {
        min = Math.min(min, value);
        max = Math.max(max, value);
        sum += value;
        sumSquares += value * value;
        count++;
    }

    void combine(AttackStats other) {
        min = Math.min(min, other.min);
        max = Math.max(max, other.max);
        sum += other.sum;
        sumSquares += other.sumSquares;
        count += other.count;
    }

    double mean() {
        return sum / count;
    }
    double stdDeviation() {
        double mean = mean();
        return Math.sqrt(sumSquares / count - mean * mean);
    }
}
