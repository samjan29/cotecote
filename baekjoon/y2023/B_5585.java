package baekjoon.y2023;

import java.util.Scanner;

public class B_5585 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int price = sc.nextInt();

        int money = 1000 - price;
        int[] changes = {500, 100, 50, 10, 5, 1};
        int count = 0;

        for (int i = 0; money > 0 ; i++) {
            if (i == 6) break;
            if (money >= changes[i]) {
                count += money / changes[i];
                money %= changes[i];
            }
        }

        System.out.println(count);
    }
}
