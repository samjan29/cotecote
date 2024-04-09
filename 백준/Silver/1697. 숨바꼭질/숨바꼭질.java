import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
    백준 1697번 숨바꼭질
    분류: 그래프 이론, 그래프 탐색, 너비 우선 탐색(bfs)
    문제: 수빈이는 점 N에 있고, 동생은 점 K에 있는데 동생이 있는 곳으로 이동하는데에 가장 빠른 시간을 구하라.
        수빈이는 걷거나 순간이동이 가능한데, 현재 수빈이가 X라는 점에 있다면
        걸을 때는 1초 후 X+1에 있거나 X-1에 있다.
        순간이동을 할 경우 1초 후 2*X에 있다.

    입력: 라인1 수빈이가 있는 점 N(0 ≤ N ≤ 10,0000)과 동생이 있는 점 K(0 ≤ K ≤ 10,0000)

    출력: 동생을 찾을 수 있는 가장 빠른 시간

    풀이: bfs로 이동할 수 있는 방법 3가지를 반복해서 동생이 있는 곳에 누가 먼저 빨리 도착하는지 찾기

    예제입력:
        5 17

        5에서
            +1  => 6
                7, 5, 12
            -1  => 4
                5, 3, 8
            2*5 => 10
                11  => 12
                       10
                       22
                9   => 10
                        8
                       18   => 19
                               17 (도착!) 4s
                               18*18
               20
    예제출력:
        4
 */
public class Main {

    static int max = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);

        bfs(N, K);

        br.close();
    }

    public static void bfs(int N, int K) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[max + 1];
        queue.offer(new int[]{N, 0});
        visited[N] = true;

        while (!queue.isEmpty()) {
            int[] n = queue.poll(); // FIFO 특징을 이용해서 가장 빠른 시간 구하기

            if (n[0] == K) {
                System.out.println(n[1]);
                return;
            }

            if (n[0] + 1 <= max && !visited[n[0] + 1]) {
                queue.offer(new int[]{n[0] + 1, n[1] + 1});
                visited[n[0] + 1] = true;
            }
            if (n[0] - 1 >= 0 && !visited[n[0] - 1]) {
                queue.offer(new int[]{n[0] - 1, n[1] + 1});
                visited[n[0] - 1] = true;
            }
            if ( n[0] * 2 <= max && !visited[n[0] * 2]) {
                queue.offer(new int[]{n[0] * 2, n[1] + 1});
                visited[n[0] * 2] = true;
            }
        }
    }

}