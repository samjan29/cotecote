import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int row = 1; row <= N; row++) {
            for (int column = 0; column < row; column++) {
                System.out.print("*");
            }

            System.out.println();
        }

        sc.close();
    }

}
