import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    백준 1654번 랜선 자르기
    분류: 이분 탐색, 매개 변수 탐색(?)
    문제: 가지고 있는 K개의 랜선을 잘라 모두 같은 길이의 N개 이상의 랜선을 만들고, 이때 랜선의 최대 길이를 구하라
        랜선을 자르거나 만들 때 손실되는 길이는 없다
        기존의 K개의 랜선으로 N개의 랜선을 만들 수 없는 경우는 없다
        자를 때는 항상 센치미터 단위의 정수길이만큼 자름
        N개보다 많이 만드는 것도 N개를 만드는 것에 포함

        !! N개의 랜선은 모두 같은 길이 !!

    입력: line 1: 길이가 제각각인 갖고 있는 랜선의 개수 K(1 <= K <= 1,0000), 필요한 랜선의 개수 N(1 <= N <= 100,0000) => K N (항상 K <= N)
        line 2: K줄에 걸쳐 갖고 있는 K개의 랜선 각각의 길이 (길이는 2^31 - 1 >= 자연수)

    출력: 만들 수 있는 랜선의 최대 길이

    풀이: 파라메트릭 서치?
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int K = Integer.parseInt(split[0]);
        int N = Integer.parseInt(split[1]);
        long[] arr = new long[K];

        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        long max = Arrays.stream(arr).max().orElseThrow();
        
        /*
            파라메트릭 서치
            1. 이진 탐색을 이용하여 최적의 값을 찾는 알고리즘
            2. 최적의 값을 찾는 문제는 결정 문제로 바꾸어 해결
            3. 결정 문제란 '예' 혹은 '아니오'로 답하는 문제
            4. 결정 문제로 바꾸어 해결할 때는 이진 탐색을 이용하여 해결
            5. 이진 탐색을 이용하여 해결할 때는 탐색 범위를 좁혀가며 최적의 값을 찾는다
         */

        long start = 1; // 랜선 길이는 자연수이기 때문에 최솟값 1
        long end = max; // 랜선 길이의 최대값은 가지고 있는 랜선 중 가장 긴 길이
        while (start <= end) {  // N보다 큰 것중 가장 작거나 같은 수를 찾아야 하기 때문에 start가 end보다 커지면 종료
            long mid = (start + end) / 2;
            long sum = Arrays.stream(arr).map(e -> e / mid).sum(); // mid 길이로 잘랐을 때 만들 수 있는 랜선의 개수

            if (sum >= N) { // N개 이상의 랜선을 만들 수 있는 경우
                start = mid + 1;    // 랜선 길이를 늘려본다
            } else {    // N개 이상의 랜선을 만들 수 없는 경우
                end = mid - 1;  // 랜선 길이를 줄여본다
            }
        }

        System.out.println(end);
        br.close();
    }
}