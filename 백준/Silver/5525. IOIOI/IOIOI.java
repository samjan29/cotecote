import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        for (int i = 1, count = 0; i < arr.length - 1; i++) {
            if (arr[i - 1] == 'I' && arr[i] == 'O' && arr[i + 1] == 'I') {
                count++;
                i++;

                if (count == N) {
                    answer++;
                    count = 0;

                    i -= 1 + 2 * (N - 1);
                }

            } else {
                count = 0;
            }

        }

        System.out.println(answer);

        br.close();
    }

}