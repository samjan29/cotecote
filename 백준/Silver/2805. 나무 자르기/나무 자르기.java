import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    백준 2805번 나무 자르기
    분류: 이분 탐색, 매개 변수 탐색
    문제: 나무 M 미터가 필요해서 N개의 나무를 자를 것이다.
        높이 H를 설정해서 그것 보다 위에 있는 나무만 잘라 갈 것이다.
        적어도 M 미터의 나무를 잘라가기 위해서 필요한 H 높이의 최댓값을 구하라

    입력: 라인 1 나무의 개수 N(1 ≤ N ≤ 100,0000), 필요한 나무 길이 M(1 ≤ M ≤ 20,0000,0000)
        라인 2 N개의 나무 각각의 높이 (0 ≤ 나무의 높이 ≤ 10,0000,0000)

        !! 나무 높이의 합은 항상 M보다 커서 나무를 가져가지 못할 경우는 없음 !!

    출력: 적어도 M 미터의 나무를 가져갈 수 있는 높이 H의 최댓값

    예제 입력1:
        4 7
        20 15 10 17
    풀이: 파라메트릭 서치를 이용해서 배열에 각각의 나무 높이를 저장하고
        (나무 높이 - mid)의 M보다 큰 수 중 가장 작거나 같을 때까지 반복을 할 것

    예제 출력:
        15
 */

public class Main {

    static long[] arr;
    static int M;
    static long max = 0;

    public static void main(String[] args) throws IOException { // O(2n + n^2)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        arr = new long[Integer.parseInt(split[0])];
        M = Integer.parseInt(split[1]);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");   //  O(n)
        for (int i = 0; i < arr.length; i++) {  // O(n)
            arr[i] = Long.parseLong(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        binarySearch();

        br.close();
    }

    public static void binarySearch() {
        long start = 1;
        long end = max;

        while (start <= end) {  // O(n^2)
            long mid = (start + end) / 2L;
            long sum = Arrays.stream(arr).map(e -> Math.max(e - mid, 0L)).sum(); // O(n)

            if (sum >= M) {
                start = mid + 1L;
            } else {
                end = mid - 1L;
            }
        }

        System.out.println(end);
    }
}