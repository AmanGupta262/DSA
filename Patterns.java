import java.util.Scanner;

class Patterns {

    public static void pattern1(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int sp = rows; sp > i; sp--) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i * 2 - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 1; i <= rows; i++) {
            for (int sp = 1; sp < i; sp++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= (rows + 1 - i) * 2 - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern2(int rows) {
        for (int i = 1; i <= rows; i++) {
            int startingNumber = i % 2;
            for (int j = 1; j <= i; j++) {
                System.out.print(startingNumber);
                if (startingNumber == 1) {
                    startingNumber -= 1;
                } else {
                    startingNumber += 1;
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern3(int rows) {

        int sp = rows * 2 - 2;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            for (int j = 1; j <= sp; j++) {
                System.out.print(" ");
            }

            for (int j = i; j > 0; j--) {
                System.out.print(j);
            }
            sp -= 2;
            System.out.println();

        }
        System.out.println();
    }

    public static void pattern4(int rows) {
        char letterToPrint = 'A';
        letterToPrint += rows - 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print((char) (letterToPrint + j));
            }
            System.out.println();
            letterToPrint -= 1;
        }
        System.out.println();
    }

    public static void pattern5(int rows) {
        for (int i = 0; i < rows; i++) {
            // stars
            for (int j = 0; j < rows - i; j++) {
                System.out.print("*");
            }

            // space
            for (int j = 0; j < i * 2; j++) {
                System.out.print(" ");
            }

            // stars
            for (int j = 0; j < rows - i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        for (int i = 0; i < rows; i++) {
            // stars
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }

            // space
            for (int j = 0; j < (rows - i - 1) * 2; j++) {
                System.out.print(" ");
            }

            // stars
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
        System.out.println();
    }

    public static void pattern6(int rows) {
        for (int i = 0; i < rows; i++) {
            // stars
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }

            // space
            for (int j = 0; j < (rows - 1 - i) * 2; j++) {
                System.out.print(" ");
            }

            // stars
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = rows - 1; i > 0; i--) {
            // stars
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }

            // space
            for (int j = 0; j < (rows - i) * 2; j++) {
                System.out.print(" ");
            }

            // stars
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern7(int rows) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if (i == 0 || j == 0 || i == rows - 1 || j == rows - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern8(int n) {
        int rows = n * 2 - 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                int rightDistance = rows - 1 - j;
                int bottomDistance = rows - 1 - i;

                System.out.print(n - Math.min(rightDistance, Math.min(bottomDistance, Math.min(i, j))));
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();

        pattern1(rows);
        pattern2(rows);
        pattern3(rows);
        pattern4(rows);
        pattern5(rows);
        pattern6(rows);
        pattern7(rows);
        pattern8(rows);

        sc.close();
    }
}