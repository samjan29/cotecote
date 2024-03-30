import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Set<String> out = new HashSet<>();
        int idx = 0;
        for (int i = 0; i < N; i++) {

            String str = br.readLine();
            if (!arr[idx].equals(str)) {
                answer++;
            }

            out.add(str);

            while (out.contains(arr[idx])) {
                if (idx == N - 1)
                    break;
                idx++;
            }
        }

        System.out.println(answer);
        br.close();
    }

}