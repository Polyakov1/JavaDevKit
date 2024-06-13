package AnotherClass;

public class PairUtils {
    public static <T extends Number> double sum(Pair<T, T> pair) {
        return pair.getFirst().doubleValue() + pair.getSecond().doubleValue();
    }

    public static <T> String concatenate(Pair<T, T> pair) {
        return pair.getFirst().toString() + pair.getSecond().toString();
    }
}