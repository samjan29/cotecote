import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < 2 * N - 1; i++) {
            for (int j = 0; j < 2 * N; j++) {
                if (i < N) {
                    if (j <= i) {
                        System.out.print("*");
                    } else if ((j >= N) && (i >= 2 * N - 1 - j)) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                } else {
                    if (j < 2 * N - 1 - i) {
                        System.out.print("*");
                    } else if ((j >= N) && (2 * N - 1 - i > 2 * N - 1 - j)) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }

        sc.close();
    }

}
