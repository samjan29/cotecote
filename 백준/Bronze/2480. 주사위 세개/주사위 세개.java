import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 0;
        int same = 0;
        int big = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    same = arr[i];
                }
            }

            if (big < arr[i]) {
                big = arr[i];
            }
        }

        if (count > 1) {   // 2 2 2
            System.out.println(10000 + same * 1000);
        } else if (count == 1) {    // 3 3 6
            System.out.println(1000 + same * 100);
        } else {
            System.out.println(big * 100);
        }

        sc.close();
    }

}
