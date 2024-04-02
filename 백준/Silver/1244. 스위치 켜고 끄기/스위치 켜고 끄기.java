import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] switchArr = new boolean[Integer.parseInt(br.readLine())];
        char[] charArray = br.readLine().toCharArray();
        int switchIdx = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ') continue;
            switchArr[switchIdx++] = charArray[i] == '1';
        }

        StringTokenizer st;
        int student = Integer.parseInt(br.readLine());
        while (student-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int gen = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if (gen == 1) {
                for (int i = n - 1; i < switchArr.length; i += n) {
                    switchArr[i] = !switchArr[i];
                }

            } else if (gen == 2) {
                n--;

                if (n == 0 || n == switchArr.length - 1) {
                    switchArr[n] = !switchArr[n];
                    continue;
                }

                int count = 0;
                while (n - count >= 0 && n + count <= switchArr.length - 1 && switchArr[n - count] == switchArr[n + count]) {
                    count++;
                }

                for (int i = n - count + 1; i <= n + count - 1; i++) {
                    switchArr[i] = !switchArr[i];
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < switchArr.length; i++) {
            sb.append(switchArr[i] ? 1 : 0);

            if ((i + 1) % 20 == 0) {
                sb.append('\n');
                continue;
            }

            if (i != switchArr.length - 1) {
                sb.append(' ');
            }
        }
        System.out.println(sb);
    }
}