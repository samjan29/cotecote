import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        String answer = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        char last = 0, start = 0, end = 0;

        while (N > 0) {
            String cur = br.readLine();

            if (cur.equals("?"))
                start = last;

            if (last == '?')
                end = cur.charAt(0);

            last = cur.charAt(cur.length() - 1);
            set.add(cur);
            N--;
        }

        int M = Integer.parseInt(br.readLine());
        while (M > 0) {
            String cur = br.readLine();
            M--;
            /*
                1. 중복되지 않을 것
                2. 조건에 맞을 것
             */
            if (set.contains(cur))
                continue;

            if (start != 0 && start != cur.charAt(0))
                continue;
            if (end != 0 && end != cur.charAt(cur.length() - 1))
                continue;

            answer = cur;
            break;
        }

        System.out.println(answer);

        br.close();
    }
}