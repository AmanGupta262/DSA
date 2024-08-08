import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeArrayBySign {

    static int[] bruteForce(int[] arr, int n) {
        ArrayList<Integer> positives = new ArrayList<Integer>();
        ArrayList<Integer> negatives = new ArrayList<Integer>();
        int[] ans = new int[n];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                positives.add(arr[i]);
            } else {
                negatives.add(arr[i]);
            }
        }

        for (int i = 0; i < arr.length / 2; i++) {
            ans[i * 2] = positives.get(i);
            ans[i * 2 + 1] = negatives.get(i);
        }

        return ans;

    }

    static int[] better(int[] arr, int n) {
        int posIndex = 0;
        int negIndex = 1;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                ans[negIndex] = arr[i];
                negIndex += 2;
            } else {
                ans[posIndex] = arr[i];
                posIndex += 2;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, -2, -5, 2, -4 };
        System.out.println(Arrays.toString(bruteForce(arr, arr.length)));
        System.out.println(Arrays.toString(better(arr, arr.length)));
    }
}