import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    백준 11399번 ATM
    분류: 그리디, 정렬
    문제: 1번 사람부터 N번 사람까지 돈을 인출하는데 걸리는 시간의 최솟값 합을 구하라

    입력: 라인 1 사람의 수 N(1 ≤ N ≤ 1,000)
        라인 2 각 사람이 돈을 인출하는데 걸리는 시간 Pi(1 ≤ Pi ≤ 1,000)

        1000 * 1000 == 100,0000

    출력: 인출하는데 걸린 시간의 합의 최솟값

    예제 입력:
        5
        3 1 4 3 2
    풀이:
        1 2 3 3 4 로 정렬 후 계산
    예제 출력:
        32
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);   // 최솟값을 구하기 위해 오름차순 정렬
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            answer += arr[i] * N--;
        }

        System.out.println(answer);
        br.close();
    }
}