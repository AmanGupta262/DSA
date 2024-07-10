import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    static void insertionSort(int[] arr, int n) {
        for (int i = 1; i < n - 1; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    swapElement(arr, j - 1, j);
                }
            }
        }
    }

    static int[] mergeTwoSortedArray(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int m = arr1.length;
        int n = arr2.length;
        int[] mergedArray = new int[m + n];

        int k = 0;
        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                mergedArray[k] = arr1[i];
                i++;
            } else {
                mergedArray[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < m) {
            mergedArray[k++] = arr1[i];
            i++;
        }

        while (j < n) {
            mergedArray[k++] = arr2[j];
            j++;
        }

        return mergedArray;
    }

    static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int middle = arr.length / 2;

        int[] leftSorted = mergeSort(Arrays.copyOfRange(arr, 0, middle));
        int[] rightSorted = mergeSort(Arrays.copyOfRange(arr, middle, arr.length));

        return mergeTwoSortedArray(leftSorted, rightSorted);
    }

    static void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(low);
        int i = low;
        int j = high;

        while (i < j) {
            while (arr.get(i) <= pivot && i <= high - 1) {
                i++;
            }

            while (arr.get(j) > pivot && j >= low + 1) {
                j--;
            }

            if (i < j) {
                swap(arr, i, j);
            }
        }

        swap(arr, low, j);
        return j;
    }

    static void qs(List<Integer> arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);
            qs(arr, low, pIndex - 1);
            qs(arr, pIndex + 1, high);
        }

    }

    public static List<Integer> quickSort(List<Integer> arr) {
        qs(arr, 0, arr.size() - 1);
        return arr;
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

        int[] arr2 = { 12, 8, 13, 9, 5, 2, 20 };
        insertionSort(arr2, 7);
        System.out.println("Insertion sort: ");
        System.out.println(Arrays.toString(arr2));

        System.out.println("Merger two sorted array: ");
        System.out.println(Arrays.toString(mergeTwoSortedArray(arr1, arr2)));

        int[] arr3 = { 5, 4, 3, 2, 1 };
        System.out.println("Merge Sort");
        System.out.println(Arrays.toString(mergeSort(arr3)));

        List<Integer> arr4 = new ArrayList<>(Arrays.asList(4, 2, 5, 1, 3));
        System.out.println("Quick Sort");
        quickSort(arr4);
        System.out.println(arr4);
    }
}
