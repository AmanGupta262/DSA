import java.util.Arrays;
import java.util.Scanner;

public class Recursion {
    static int factorial(int n) {
        if (n < 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    static void reverseArray(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        reverseArray(arr, i + 1, j - 1);

    }

    static boolean isAlphabet(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    static boolean isPalindrome(String s, int start, int end) {
        if (start >= end) {
            return true;
        }

        if (!isAlphabet(s.charAt(start))) {
            return isPalindrome(s, start + 1, end);
        }
        if (!isAlphabet(s.charAt(end))) {
            return isPalindrome(s, start, end - 1);
        }

        if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
            return false;
        }

        return isPalindrome(s, start + 1, end - 1);
    }

    static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(factorial(n));

        reverseArray(arr, 0, 4);
        System.out.println(Arrays.toString(arr));

        String str = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(str, 0, str.length() - 1));

        System.out.println(fib(n));
        sc.close();
    }
}
