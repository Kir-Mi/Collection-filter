import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5};
        Filter<Integer> filter = new FilterImpl<Integer>();
        Integer[] ints = filter(array, filter);
    }

    public static <T> T[] filter(T[] array, Filter<T> filter) {
        return Arrays.stream(array)
                .map(filter::apply)
                .toArray(size -> Arrays.copyOf(array, size));
    }

    interface Filter<T> {
        Object apply(T o);
    }

    static class FilterImpl<T> implements Filter<T> {
        @Override
        public Object apply(Object o) {
            System.out.println(o.toString());
            return o;
        }
    }
}