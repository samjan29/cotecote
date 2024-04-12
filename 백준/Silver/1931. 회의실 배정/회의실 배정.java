import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
    백준 1931번 회의실 배정
    문제: 회의 시간이 주어지는데
        각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 구하라.
        한 회의가 끝나는 것과 동시에 다음 회의가 시작

    입력: 라인1 회의의 수 N(1 ≤ N ≤ 100,000)
        라인2부터 N+1 줄까지 각 회의의 정보

        시작 시간과 끝나는 시간은 2^31-1보다 작거나 같은 자연수 또는 0

    출력: 최대 사용할 수 있는 회의의 최대 개수!!
        회의실의 최대가 아님;;

    풀이: 우선순위 큐에 넣어서 다음 회의 시작시간이 이전 회의 끝시간보다 크거나 같으면 다음 회의

 */
public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        }));

        for (int i = 0; i < N; i++) {
             pq.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }

        int answer = 1;
        int end = pq.poll()[1];
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            if (end <= temp[0]) {
                end = temp[1];
                answer++;
            }
        }

        System.out.println(answer);
        br.close();
    }

}