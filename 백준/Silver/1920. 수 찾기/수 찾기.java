import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    백준 1920번 수 찾기
    분류: 정렬, 이분 탐색
    문제: N개의 정수가 주어졌을 때, X라는 정수가 존재하는지

    입력: 자연수 N (1 ≤ N ≤ 10,0000) => 배열
        N개의 정수 A[1], A[2], …, A[N] => 정렬된
        자연수 M (1 ≤ M ≤ 100,000) =>  배열 안에서 찾아야 하는 숫자의 총 갯수
        M개의 정수

        모든 정수의 범위는 -2^31 보다 크거나 같고 2^31보다 작다. => int 최솟값 최댓값

    출력: 배열에 존재하면 1, 아니면 0

    풀이: 배열에 담고 sort 후 이분 탐색
 */

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());    // O(n)
        arr = new int[N];
        for (int i = 0; i < N; i++) {   // O(n)
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);   // O(n * log n)

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());    // O(n)
        while (M-- > 0) {
            binarySearch(Integer.parseInt(st.nextToken()));
        }

        System.out.println(sb);
        br.close();
    }

    public static void binarySearch(int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == arr[mid]) {
                sb.append(1).append('\n');
                return;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        sb.append(0).append('\n');
    }
}