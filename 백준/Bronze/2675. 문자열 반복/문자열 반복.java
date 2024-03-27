import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int[] Rarr = new int[T];
        String[] Sarr = new String[T];

        for (int i = 0; i < T; i++) {
            Rarr[i] = sc.nextInt();
            Sarr[i] = sc.next();
        }

        for (int i = 0; i < T; i++) {
            StringBuffer sb = new StringBuffer();

            for (int j = 0; j < Sarr[i].length(); j++) {
                for (int k = 0; k < Rarr[i]; k++) {
                    sb.append(Sarr[i].charAt(j));
                }
            }

            System.out.println(sb.toString());
        }

        sc.close();
    }

}
