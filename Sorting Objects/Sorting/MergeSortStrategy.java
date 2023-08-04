/**
 * Merge Sort is a divide-and-conquer algorithm that divides an unsorted list into several sublists, each containing one element. 
 * It repeatedly merges these sublists in a pairwise manner until a single sorted list remains.
 **/

public class MergeSortStrategy implements SortingStrategy {
    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        mergeSort(array, 0, array.length - 1);
    }
    
    private <T extends Comparable<T>> void mergeSort(T[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }
    private <T extends Comparable<T>> void merge(T[] array, int left, int mid, int right) {
        int low = mid - left + 1;
        int high = right - mid;
        T[] leftArray = (T[]) new Comparable[low];
        T[] rightArray = (T[]) new Comparable[high];
        for (int i = 0; i < low; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < high; j++) {
            rightArray[j] = array[mid + 1 + j];
        }
        int i = 0, j = 0, k = left;
        while (i < low && j < high) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        // Copy the remaining elements from the left array
        while (i < low) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        // Copy the remaining elements from the right array
        while (j < high) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
