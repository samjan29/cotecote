import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int max = 0, row = 1, column = 1;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                int n = Integer.parseInt(st.nextToken());

                if (n > max) {
                    max = n;
                    row = i + 1;
                    column = j + 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append('\n').append(row).append(' ').append(column);
        System.out.println(sb);
    }

}