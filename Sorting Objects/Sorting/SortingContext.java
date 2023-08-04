public class SortingContext {
    private SortingStrategy strategy;

    public SortingContext(SortingStrategy strategy) {
        this.strategy = strategy;
    }
    public <T extends Comparable<T>> void sortArray(T[] array) {
        strategy.sort(array);
    }
    public SortingStrategy getStrategy() {
        return strategy;
    }
    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }
}
