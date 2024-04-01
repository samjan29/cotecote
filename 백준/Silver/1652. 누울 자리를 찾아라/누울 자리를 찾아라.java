import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] room = new char[N][];
        for (int i = 0; i < N; i++) {
            room[i] = br.readLine().toCharArray();
        }

        int horizontal = 0, vertical = 0;
        int row = -1, column = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (room[i][j] == '.' && room[i][j + 1] == '.') {
                    horizontal++;
                    if (column == j) {
                        horizontal--;
                    }
                    column = j + 1;
                }

                if (room[j][i] == '.' && room[j + 1][i] == '.') {
                    vertical++;
                    if (row == j) {
                        vertical--;
                    }
                    row = j + 1;
                }
            }
            column = -1;
            row = -1;
        }

        System.out.println(horizontal + " " + vertical);
    }

}