import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        String answer = "I'm Sorry Hansoo";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] alph = new int['Z' - 'A' + 1];

        int len = s.length();

        for (int i = 0; i < len; i++) {
            int idx = s.charAt(i) - 'A';
            alph[idx]++;
        }
        
        StringBuilder sb = new StringBuilder();
        int countOne = 0;
        int oddIdx = -1;
        for (int i = 0; i < alph.length; i++) {
            if (alph[i] % 2 != 0) {
                countOne++;
                if (countOne > 1) {
                    System.out.println(answer);
                    return;
                }
            }

            int count = 0;
            for (int j = 0; j < alph[i] / 2; j++) {
                sb.append((char) (i + 'A'));
                count++;
            }
            if (alph[i] % 2 != 0 && alph[i] - count >= 1)
                oddIdx = i;
        }

        answer = sb.toString() + (oddIdx == -1 ? "" : (char) (oddIdx + 'A'));
        answer += sb.reverse().toString();
        System.out.println(answer);

        br.close();
    }

}