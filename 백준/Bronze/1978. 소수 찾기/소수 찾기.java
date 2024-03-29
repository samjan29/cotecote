import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");

        o:
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(strArr[i]);
            if (n == 1 || (n != 2 && n % 2 == 0)) {
                continue;
            }
            double root = Math.sqrt(n);
            for (int j = 3; j <= root; j++) {
                if (n % j == 0) {
                    continue o;
                }
            }

            answer++;
        }

        System.out.println(answer);

        br.close();
    }

}