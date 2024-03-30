import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]);  // 첫 글자는 항상 대문자
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == '-') {
                sb.append(arr[i + 1]);  // 하이픈 뒤에는 반드시 대문자
            }
        }

        System.out.println(sb);
        br.close();
    }
}