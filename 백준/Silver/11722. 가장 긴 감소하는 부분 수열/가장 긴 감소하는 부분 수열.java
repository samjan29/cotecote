import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
    백준 11722번 가장 긴 감소하는 부분 수열
    문제: 수열 A의 점점 감소하면서 가장 긴 부분 수열을 구하고 그 길이를 출력

    입력: 라인1 수열 A의 크기 N (1 ≤ N ≤ 1,000)
        라인2 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)

    출력: 수열 A의 가장 긴 감소하는 부분 수열의 길이

    풀이: 수열 A를 입력 받고
        0번째 인덱스부터 탐색
        int[A.length][A.length]를 사용해서

 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            dp[i] = 1;  // A[i] 포함
            for (int j = 0; j <= i; j++) {
                if (A[i] < A[j] && dp[i] < dp[j] + 1)   // dp 배열의 i 인덱스에는 수열에서 처음부터 해당 수(i 인덱스)까지 탐색했을 때 감소하는 수열의 길이를 저장
                    dp[i] = dp[j] + 1;
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
        br.close();
    }

}