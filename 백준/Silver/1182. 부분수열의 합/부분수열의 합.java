import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    백준 1182번 부분수열의 합
    문제: N개의 정수로 이루어진 수열의 부분수열의 원소를 다 더해서 S가 되는 경우의 수를 찾아라

    입력: 라인1 수열의 원소의 개수 N(1 ≤ N ≤ 20) 부분수열의 합 S(|S| ≤ 100,0000)
        라인2 N개의 수열의 원소 정수

    출력: S가 되는 부분 수열의 개수

    풀이: 원소를 넣었다 안 넣었다 해야함
 */
public class Main {

    static int[] arr;
    static int N;
    static int S;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        S = Integer.parseInt(split[1]);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        System.out.println(S == 0 ? count - 1 : count); // 0인 경우 아무 것도 안넣었을 때 count가 0이라서 +1 된 것을 빼줘야 함
        br.close();
    }

    public static void dfs(int sum, int depth) {
        if (depth == N) {
            if (sum == S) {
                count++;
            }
            return;
        }

        dfs(sum + arr[depth], depth + 1);   // 이 숫자를 부분순열에 넣을 경우
        dfs(sum, depth + 1);    // 이 숫자를 부분순열에 넣지 않을 경우
    }
    
    /*
        -7 -3 -2 5 8
        -7 -3 -2 5 X
        -7 -3 -2 X 8
        -7 -3 -2 X X
        -7 -3  X 5 8
        -7 -3  X 5 X
        -7 -3  X X 8
        -7 -3  X X X
     */

}