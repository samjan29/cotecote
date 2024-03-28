import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[2];
        for (int i = 0; i < arr.length; i++) {
            String str = st.nextToken();
            for (int j = str.length() - 1; j >= 0; j--) {
                arr[i] *= 10;
                arr[i] += str.charAt(j) - '0';
            }
        }

        System.out.println(Math.max(arr[0], arr[1]));

        br.close();
    }

}