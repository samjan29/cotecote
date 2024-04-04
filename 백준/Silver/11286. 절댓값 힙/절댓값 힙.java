import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
    백준 11286번 절댓값 힙
    분류: 우선순위 큐
    문제: N개의 정수가 주어질 때
        배열에 정수 x(x!=0) 삽입
        0이 입력되면 가장 작은 값을 출력
        배열에서 그 수를 제거

    입력: N(1<=N<=100,000)
        x(-2^31<x<=2^31 => -21,4748,3648<x<=21,4748,3647 -> int MIN과 MAX)
    출력: 1. 절댓값이 가장 작은 수가 여러개이면, 기존 값이 가장 작은 값을 출력
        2. 배열이 비어있을 경우 0 출력

    풀이: 객체를 감싼 우선순위 큐 선언
        객체는 절댓값과 원래값을 가지고 있음
        절댓값이 작은 순서대로 정렬
        절댓값이 같으면 원래값이 작은 순서대로 정렬
        0이 입력되면 큐에서 가장 작은 값을 출력

    예제 입력1:
        18      정수의 개수: 18                      pq: {}
        1   -> 우선순위 큐에 (1, 1) 삽입            pq: {1}
        -1  -> 우선순위 큐에 (1, -1) 삽입           pq: {-1, 1}
        0   -> 우선순위 큐에서 가장 작은 값 출력 "-1"     pq: {1}
        0   -> 우선순위 큐에서 가장 작은 값 출력 "1"      pq: {}
        0   -> 큐가 비어있어서 0 출력 "0"            pq: {}
        1   -> 우선순위 큐에 (1, 1) 삽입            pq: {1}
        1   -> 우선순위 큐에 (1, 1) 삽입            pq: {1, 1}
        -1  -> 우선순위 큐에 (1, -1) 삽입           pq: {-1, 1, 1}
        -1  -> 우선순위 큐에 (1, -1) 삽입           pq: {-1, -1, 1, 1}
        2   -> 우선순위 큐에 (2, 2) 삽입            pq: {-1, -1, 1, 1, 2}
        -2  -> 우선순위 큐에 (2, -2) 삽입           pq: {-1, -1, 1, 1, -2, 2}
        0   -> 우선순위 큐에서 가장 작은 값 출력 "-1"    pq: {-1, 1, 1, -2, 2}
        0   -> 우선순위 큐에서 가장 작은 값 출력 "-1"    pq: {1, 1, -2, 2}
        0   -> 우선순위 큐에서 가장 작은 값 출력 "1"     pq: {1, -2, 2}
        0   -> 우선순위 큐에서 가장 작은 값 출력 "1"     pq: {-2, 2}
        0   -> 우선순위 큐에서 가장 작은 값 출력 "-2"    pq: {2}
        0   -> 우선순위 큐에서 가장 작은 값 출력 "2"     pq: {}
        0   -> 큐가 비어있어서 0 출력 "0"            pq: {}

 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<MinimumX> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {   // 0이 입력되면 가장 작은 값을 출력
                if (pq.isEmpty()) { // 배열이 비어있을 경우 0 출력
                    sb.append(0).append("\n");
                } else {   // 가장 작은 값을 출력
                    sb.append(pq.poll().oriVal).append("\n");

                }
            } else {
                pq.add(new MinimumX(Math.abs(x), x));
            }
        }

        System.out.println(sb);
        br.close();
    }

    private static class MinimumX implements Comparable<MinimumX> {
        int absVal;
        int oriVal;

        public MinimumX(int absVal, int oriVal) {
            this.absVal = absVal;
            this.oriVal = oriVal;
        }

        @Override
        public int compareTo(MinimumX o) {
            if (this.absVal == o.absVal) {
                return Long.compare(this.oriVal, o.oriVal);
            }
            return Long.compare(this.absVal, o.absVal);
        }
    }
}