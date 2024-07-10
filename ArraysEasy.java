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

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 7, 7, 5 };
        int[] arr1 = { 28078, 19451, 935, 28892, 2242, 3570, 5480, 231 };

        System.out.println("Largest element: " + largestElement(arr));

        // secondLargestSmallestElement(arr);
        secondLargestSmallestElement(arr1);
    }
}
