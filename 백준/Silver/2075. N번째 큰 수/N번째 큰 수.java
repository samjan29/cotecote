import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
    백준 2075번 N번째 큰 수
    분류: 우선순위 큐
    문제: N x N 배열에 수가 주어질 때, N번째 큰 수를 구하라

    입력: N(1 <= N <= 1500), N x N 배열에 들어갈 정수(-10억 <= 수 <= 10억)
    출력: N번째 큰 수

    풀이: 우선순위 큐에 내림차순으로 넣고, N번 poll()
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 배열의 크기
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1); // 내림차순 정렬 우선순위 큐
        StringTokenizer st; // 토큰 수가 많을 것 같아서 StringTokenizer 사용
        for (int i = 0; i < N; i++) {   // O(1500^2) = O(2,250,000) => N == 1500인 최악의 경우
            st = new StringTokenizer(br.readLine(), " ");   // O(1500)
            for (int j = 0; j < N; j++) {   // O(1500)
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < N - 1; i++) {   // 출력할 때 N번째 큰 수를 출력하기 위해 N-1번 poll()
            pq.poll();
        }

        System.out.println(pq.poll());

        br.close();
    }
}