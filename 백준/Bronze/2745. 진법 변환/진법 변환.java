import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        long answer = 0L;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        char[] charArr = strArr[0].toCharArray();
        int n = Integer.parseInt(strArr[1]);

        for (int i = 0; i < charArr.length; i++) {
            int tmp = 0;
            if (charArr[i] >= 'A' && charArr[i] <= 'Z') {
                tmp = charArr[i] - 'A' + 10;
            } else {
                tmp = charArr[i] - '0';
            }
            answer += pow(n, charArr.length - 1 - i) * tmp;
        }

        System.out.println(answer);
        br.close();
    }

    public static long pow(int x, int y) {
        long result = 1;
        for (int i = 0; i < y; i++) {
            result *= x;
        }
        return result;
    }
}
