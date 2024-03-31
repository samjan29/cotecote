import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] idxArr = br.readLine().split(" ");
        N = Integer.parseInt(idxArr[0]);
        M = Integer.parseInt(idxArr[1]);

        int[][] arr1 = new int[N][M];
        input(arr1);
        int[][] arr2 = new int[N][M];
        input(arr2);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                 sb.append(arr1[i][j] + arr2[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void input(int[][] arr) throws IOException {
        for (int i = 0; i < N; i++) {
            String[] sArr = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(sArr[j]);
            }
        }
    }

}