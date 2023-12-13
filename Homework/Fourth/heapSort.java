//Alex Picard
import java.util.Arrays;
public class heapSort<E extends Comparable<E>> {
    public void heapSort(E[] arr){
        int N = arr.length;
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);

        for (int i = N - 1; i > 0; i--) {
            E temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }
    void heapify(E[] arr, int N, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2; 
        if (l < N && arr[l].compareTo(arr[largest]) > 0)
            largest = l;
        if (r < N && arr[r].compareTo(arr[largest]) > 0)
            largest = r;
        if (largest != i) {
            E swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, N, largest);
        }
    }

    // Driver's code
    public static void main(String args[]) {
        Integer[] arr = {33, 57, 21, 7, 45, 3, 27, 25, 40, 12};
        heapSort<Integer> sorter = new heapSort<>();

        System.out.println("Original array: " + Arrays.toString(arr));

        sorter.heapSort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
