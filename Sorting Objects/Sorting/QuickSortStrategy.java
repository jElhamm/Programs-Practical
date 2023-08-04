/**
 * Quick Sort is a divide-and-conquer algorithm that operates by selecting a pivot element from the array and partitioning the other elements into two sub-arrays, 
 * according to whether they are less than or greater than the pivot.
 * The sub-arrays are then recursively sorted.
 **/

public class QuickSortStrategy implements SortingStrategy {
    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }
    
    private <T extends Comparable<T>> void quickSort(T[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }
    private <T extends Comparable<T>> int partition(T[] array, int low, int high) {
        T pivot = array[high];
        int i = low - 1;
        for (int j=low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        T temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}