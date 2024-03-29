import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        outer:
        for (int i = M; i <= N ; i++) {
            if (i == 1 || (i != 2 && i % 2 == 0)) continue;
            double root = Math.sqrt(i);
            for (int j = 3; j <= root; j += 2) {
                if (i % j == 0) {
                    continue outer;
                }
            }

            bw.write(i + "\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }

}