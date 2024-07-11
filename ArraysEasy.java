import java.util.Arrays;

public class ArraysEasy {
    static int largestElement(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    static void secondLargestSmallestElement(int[] arr) {
        if (arr.length <= 1) {
            System.out.println("Second largest " + -1 + " Second smallest " + -1);
        }
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int secondMin = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            }

            if (arr[i] < max && arr[i] > secondMax) {
                secondMax = arr[i];
            }

            if (arr[i] < min) {
                secondMin = min;
                min = arr[i];
            }

            if (arr[i] > min && arr[i] < secondMin) {
                secondMin = arr[i];
            }
        }

        System.out.println(
                "Second largest " + (secondMax == Integer.MIN_VALUE ? -1 : secondMax) + " Second smallest "
                        + (secondMin == Integer.MAX_VALUE ? -1 : secondMin));
    }

    // Array is sorted in ascending order
    static boolean checkArrayIsSortedAndRotated(int[] arr) {
        int count = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                count++;
            }
        }

        if (arr[arr.length - 1] > arr[0]) {
            count++;
        }

        return count <= 1;
    }

    // Array is sorted in ascending order
    static int removeDuplicates(int[] arr) {
        if (arr.length <= 1) {
            return arr.length;
        }

        int i = 0;

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] > arr[i]) {
                i += 1;
                arr[i] = arr[j];
            }
        }

        return i + 1;

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 7, 7, 5 };
        int[] arr1 = { 28078, 19451, 935, 28892, 2242, 3570, 5480, 231 };

        System.out.println("Largest element: " + largestElement(arr));

        secondLargestSmallestElement(arr);
        secondLargestSmallestElement(arr1);

        int[] arr2 = { 4, 1, 2, 3 };
        System.out.println("Is array sorted and rotated: " + checkArrayIsSortedAndRotated(arr2));

        int[] arr3 = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        removeDuplicates(arr3);
        System.out.println(Arrays.toString(arr3));
    }
}
