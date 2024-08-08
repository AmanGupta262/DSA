import java.util.Arrays;

public class NextPermutation {
    static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    static void nextPermutation(int[] arr, int n) {
        int breakPoint = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                breakPoint = i;
                break;
            }
        }

        if (breakPoint < 0) {
            reverseArray(arr, 0, n - 1);
            return;
        }

        for (int i = n - 1; i > breakPoint; i--) {
            if (arr[i] > arr[breakPoint]) {
                int temp = arr[breakPoint];
                arr[breakPoint] = arr[i];
                arr[i] = temp;
                break;
            }
        }

        reverseArray(arr, breakPoint + 1, n - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 3 };

        nextPermutation(arr, arr.length);
    }
}
