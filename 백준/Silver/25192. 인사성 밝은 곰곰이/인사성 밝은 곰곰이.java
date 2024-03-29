import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> chatSet = new HashSet<>();
        int N = Integer.parseInt(br.readLine());

        while (N > 0) {
            String str = br.readLine();
            if (!chatSet.isEmpty() && str.equals("ENTER")) {
                answer += chatSet.size();
                chatSet.clear();
                N--;
                continue;
            }

            if (!str.equals("ENTER")) {
                chatSet.add(str);
            }

            N--;
            if (N == 0) {
                answer += chatSet.size();
            }
        }

        System.out.println(answer);

        br.close();
    }

}