package year2023.month01;

import java.util.Scanner;

public class Day27_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++)
            System.out.println("*".repeat(i));
    }
}
