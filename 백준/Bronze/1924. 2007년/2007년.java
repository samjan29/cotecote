import java.util.Scanner;

public class Main {

    static int[] endDate = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String[] dayOfWeek = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int D = sc.nextInt();

        int countDays = 0;
        for (int i = 0; i < M; i++) {
            if (i == M - 1) {
                countDays += D;
                break;
            }

            countDays += endDate[i];
        }

        System.out.println(dayOfWeek[countDays % 7 == 0 ? dayOfWeek.length - 1 : countDays % 7 - 1]);

        sc.close();
    }

}
