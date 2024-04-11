import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    백준 16173번 점프왕 쩰리 (Small)
    문제: 정사각형의 가장 좌측 상단에서 시작
        정사각형의 가장 우측 하단에 도착하면 쩰리의 승리
        쩰리는 오른쪽과 아래로만 이동 가능
        이동할 수 있는 칸 수는 밟고 있는 곳에 적혀 있음
        승리 할 수 있는지 없는지를 확인 => dfs

    입력: 라인1 게임 구역의 크기 N (2 ≤ N ≤ 3)
        라인2부터 N * N만큼 발판의 값이 입력 됨

        게임판의 승리 지점(오른쪽 맨 아래 칸)에는 -1이 쓰여있고, 나머지 칸에는 0 이상 100 이하의 정수가 쓰여있다.

    출력: 승리 할 수 있으면 "HaruHaru"
        할 수 없으면 "Hing"

    풀이:

 */
public class Main {

    static boolean isWin = false;
    static int N;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }

        dfs(0, 0);

        if (isWin) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }

        br.close();
    }

    public static void dfs(int x, int y) {
        if (x >= N || y >= N) {
            return;
        }

        if (board[x][y] == 0) {
            return;
        }

        if (board[x][y] == -1) {
            isWin = true;
            return;
        }

        dfs(x, y + board[x][y]);  // 현재 위치에서 오른쪽으로
        dfs(x + board[x][y], y);  // 현재 위치에서 아래로
    }
}
