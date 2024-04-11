import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    백준 17086번 아기 상어 2
    문제: N * M의 공간에서 아기 상어들의 위치를 보고 가장 안전한 위치를 구하라
        예제 입력1:
            2 1 s 1
            1 1 1 1
            s 1 2 2     => 가까울수록 위험하다는 것 == 상어의 인접지역 1이 가장 위험한 빈 공간 => 2가 그다음으로 위험한 == 가장 안전한 지역
            1 1 1 1
            2 2 1 s
        모든 아기 상어들과 가장 멀리 떨어진 위치 => 위에서는 1
        상어의 8방향이 위험지대

    입력: 라인1 공간의 크기 N과 M (2 ≤ N, M ≤ 50)
        라인2부터 공간 N * M 에서 빈 공간과 아기 상어의 위치

    출력: 가장 안전한 곳에서 상어와의 최소 거리

    풀이: 최소의 거리니까 너비 우선 탐색으로
        상어가 위치한 공간을 큐에 넣는다 => 상어 위치는 -99로(?)
        하나씩 큐에서 제거하며 방향 벡터로 8방향을 탐색하며 상어와 가장 가까운 공간부터 1로 채운다.
        1로 채운 공간을 또 큐에 넣는다
        하나씩 큐에서 제거하며 방향 벡터로 8방향으로 탐색하고 1과 가장 가깝고 0인 공간을 2로 채운다.
        .
        .
        .
        공간의 거리를 구하기??

 */
public class Main {

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    static int N;
    static int M;
    static int[][] space;
    static int bestSafePlace;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        space = new int[N][M];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1) {
                    queue.offer(new int[]{i, j});
                    space[i][j] = -99;
                }
            }
        }

        bfs();

        System.out.println(bestSafePlace);
        br.close();
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int[] target = queue.poll();
            int safe;
            if (space[target[0]][target[1]] == -99) {
                safe = 1;
            } else {
                safe = space[target[0]][target[1]] + 1;
            }

            boolean isChange = false;   // 주변이 바뀌지 않았으면 지금 공간보다 더 안전한 공간이 없는 것
            for (int i = 0; i < 8; i++) {
                int nx = target[0] + dx[i], ny = target[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || space[nx][ny] != 0) {
                    continue;
                }
                isChange = true;
                space[nx][ny] = safe;
                queue.offer(new int[]{nx, ny});
            }

            if (isChange) {
                bestSafePlace = safe;
            }
        }
    }
}