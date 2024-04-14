import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    백준 2293번 동전 1
    문제: n가지의 가치가 다른 동전으로 k원을 만들 수 있는 경우의 수를 구하라

    입력: n, k (1 ≤ n ≤ 100, 1 ≤ k ≤ 1,0000)
        각각의 동전의 가치 (1 ≤ 동전의 가치 ≤ 10,0000)
        1원의 동전 10개로 10원
        2원의 동전 5개로 10원
        1원 2개 2원 4개로 10원
        ...

    출력: 모든 경우의 수

    풀이:

 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        int[] dp = new int[k + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int coin = Integer.parseInt(br.readLine());
            for (int j = coin; j <= k; j++) {
                dp[j] += dp[j - coin];
            }
        }

        System.out.println(dp[k]);
        br.close();
    }

}