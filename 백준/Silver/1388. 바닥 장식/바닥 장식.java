import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    백준 1388번 바닥 장식
    분류: 그래프 탐색, 깊이 우선 탐색(dfs)
    문제: 바닥 장식을 하는데 모두 몇개의 판자가 필요한지 구하라
        -, --, ---, ---- => 모두 한개의 나무 판자로 세로도 같음
        판자가 벽에 있거나 다른 방향 판자로 끊기지 않았으면 하나의 판자
        바닥은 직사각형

    입력: 라인1 세로 N 가로 M => [N][M] (1 <= N, M <= 50)
        라인2부터 바닥 장식 무늬

    출력: 필요한 나무 판자의 수

    풀이: charArray로 받을 것
        '-'인지 '|'인지에 따라 다를 것
        visited 배열을 이용해서 방문한 곳을 true로 해서 재방문 하지 않을 것
 */
public class Main {

    static int N;
    static int M;
    static char[][] arr;
    static boolean[][] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        arr = new char[N][];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    continue;
                }

                dfs(i, j, arr[i][j]);
            }
        }

        System.out.println(answer);
        br.close();
    }

    public static void dfs(int i, int j, char type) {
        if (i == N || j == M || type != arr[i][j] ) {
            answer++;
            return;
        }

        visited[i][j] = true;
        switch (type) {
            case '-':
                dfs(i, j + 1, type);
                break;
            case '|':
                dfs(i + 1, j, type);
                break;
        }
    }

}