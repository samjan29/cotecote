import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int X = sc.nextInt();

        int n = 0;
        int sum = 0;
        while (sum < X) {
            sum += ++n;
        }
        
        int num = n % 2 == 0 ? 1 : n;
        int den = n % 2 == 0 ? n : 1;

        for (int i = 0; i < sum - X; i++) {
            if (n % 2 == 0) {
                num += 1;
                den -= 1;
            } else {
                num -= 1;
                den += 1;
            }
        }
        
        sb.append(den).append("/").append(num);
        System.out.println(sb.toString());

        sc.close();
    }

}