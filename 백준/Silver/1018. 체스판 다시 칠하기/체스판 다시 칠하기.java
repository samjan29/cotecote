import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;
    static boolean[][] check;
    static boolean[][] chess;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        check = new boolean[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                check[i][j] = (i + j) % 2 == 0;
            }
        }

        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);

        chess = new boolean[N + 8][M + 8];
        for (int i = 0; i < N; i++) {
            char[] charArr = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                chess[i][j] = charArr[j] == 'W';
            }
        }

        int answer = 64;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                answer = Math.min(answer, compare(i, j));
            }
        }

        System.out.println(answer);
    }

    public static int compare(int x, int y) {
        int count = 0;
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (chess[i][j] != check[i - x][j - y]) {
                    count++;
                }
            }
        }

        return count > 64 / 2 ? 64 - count : count;
    }

}