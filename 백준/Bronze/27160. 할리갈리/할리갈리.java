import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] Xarr = new int[4];

        int N = Integer.parseInt(br.readLine());

        while (N > 0) {
            String[] arr = br.readLine().split(" ");

            int X = Integer.parseInt(arr[1]);
            switch (arr[0]) {
                case "STRAWBERRY":
                    Xarr[0] += X;
                    break;
                case "BANANA":
                    Xarr[1] += X;
                    break;
                case "LIME":
                    Xarr[2] += X;
                    break;
                case "PLUM":
                    Xarr[3] += X;
                    break;
            }

            N--;
        }

        String answer = null;
        for (int X : Xarr) {
            if (X == 5) {
                answer = "YES";
                break;
            }

            answer = "NO";
        }
        System.out.println(answer);

        br.close();
    }

}