import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    백준 11722번 RGB 거리
    문제: 1번부터 순서대로 1, 2, 3, ... , N-1, N 집이 있다.
        옆에 있는 집은 서로 색이 같지 않다.

    입력: 라인1 집의 수 N(2 ≤ N ≤ 1,000)
        라인2부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용

    출력: 모든 집을 칠하는 비용의 최솟값

    풀이: 뭘 더 해서 저장해놔야 하는지 모르겠음
        => 풀이를 봤더니 1번 인덱스부터 N까지 돌면서
            cost[i][0] = Math.min(cost[i-1][1], cost[i-1][2]) + cost[i][0];
            이렇게 앞의 집에 누적된 값 중 작은 값과 i번 집의 비용 중 가장 작은 값을 더해서 경우의 수를 정하는 것 같다.
            근데 i-1, i, i+1이 색이 다른 조건을 어떻게 만족했는지 모르겠다

 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][];
        for (int i = 1; i <= N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        arr[0] = new int[3];
        for (int i = 1; i <= N; i++) {
            arr[i][0] = Math.min(arr[i - 1][1], arr[i - 1][2]) + arr[i][0];
            arr[i][1] = Math.min(arr[i - 1][0], arr[i - 1][2]) + arr[i][1];
            arr[i][2] = Math.min(arr[i - 1][0], arr[i - 1][1]) + arr[i][2];
        }

        System.out.println(Math.min(Math.min(arr[N][0], arr[N][1]), arr[N][2]));

        br.close();
    }

}