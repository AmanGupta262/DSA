import java.util.Arrays;

public class Sort {

    static void swapElement(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int findMinIndex(int[] arr, int i) {
        int minIndex = i;

        for (int j = i + 1; j < arr.length; j++) {

            if (arr[minIndex] > arr[j]) {
                minIndex = j;
            }
        }

        return minIndex;
    }

    static void selectionSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int minIndex = findMinIndex(arr, i);

            swapElement(arr, i, minIndex);
        }

    }

    static void bubbleSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            boolean swapped = false;
            for (int j = 1; j < n - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swapElement(arr, j - 1, j);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, 1, 0, -1 };

        selectionSort(arr);
        System.out.println("Selection sort: ");
        System.out.println(Arrays.toString(arr));

        int[] arr1 = { 9, 4, 10, 0, -1 };

        bubbleSort(arr1, 5);
        System.out.println("Bubble sort: ");
        System.out.println(Arrays.toString(arr1));
    }
}
