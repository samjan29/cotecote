import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
    백준 15903번 카드 합체 놀이
    분류: 그리디, 우선순위 큐
    문제: n개의 카드 묶음
        x번 카드와 y번 카드에 적힌 숫자를 더한 값을 x번 카드와 y번 카드에 저장
        이 작업을 m번 반복하고 n개의 카드에 적힌 수를 모두 더해서 출력
    조건: x != y, 서로 값은 같아도 상관 없고 위치는 달라야 함
        만들 수 있는 가장 작은 수를 구해야 함

    입력: n(2≤n≤1,000), m(0≤m≤15×n) -> 15xn 최대: 15*1000=15000
        N개의 카드 묶음에 적힌 수(1<=수<=10^6)
    출력: n개의 카드에 적힌 수의 합 -> 적힐 수 있는 최댓값: 10^6*15000*1000=150,0000,0000 -> int로 불가능

    풀이: 우선순위 큐를 사용하여 가장 작은 두 수를 뽑아 더한 후 다시 큐에 넣는 방식으로 해결

    예제 입력1:
        3 1
        3 2 6
        1번: 3+2=5 -> 5 5 6
        출력: 16
    예제 입력2:
        4 2
        4 2 3 1
        1번: 1+2=3 -> 3 3 3 4
        2번: 3+3=6 -> 3 4 6 6
        출력: 19
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]); // 배열의 크기
        int m = Integer.parseInt(split[1]); // 합체 횟수

        PriorityQueue<Long> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) { // O(1000)
            pq.add(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < m; i++) { // O(15000)
            long a = pq.poll();
            long b = pq.poll();
            pq.add(a + b);
            pq.add(a + b);
        }

        long answer = 0;
        while (n-- > 0) {   // O(1000)
            answer += pq.poll();
        }

        System.out.println(answer);
        br.close();
    }
}