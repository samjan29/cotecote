import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double total = 0.0;

        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int max = 0, idx = 0;
        while (st.hasMoreTokens()) {
            int s = Integer.parseInt(st.nextToken());
            arr[idx++] = s;

            if (s > max) {
                max = s;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            total += arr[i] / max * 100;
        }

        System.out.println(total / N);

        br.close();                ;
    }

}