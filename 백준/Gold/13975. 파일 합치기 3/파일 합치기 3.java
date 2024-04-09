import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    백준 13975번 파일 합치기 3
    분류: 그리디, 우선순위 큐
    문제: 파일마다 크기가 다르고 파일을 합치는데 필요한 시간은 두 파일의 크기의 합이다.
        파일이 하나 남을 때까지 파일을 합치는데 걸리는 최소 시간을 구하라

    입력: 라인1 테스트 케이스 수 T
        T1 소설을 구성하는 장의 수 K(3 ≤ K ≤ 100,0000)
            1장부터 K장까지의 파일 크기 (최소 1이지 않을까? 파일 크기 < 1,0000)   => 1,0000 * 100,0000 == 100,0000,0000
        T2 위와 같음
        ...
        Tn 마지막 테스트 케이스

    출력: 파일을 합치는데 걸리는 최소 시간

    풀이:

    예제입력:
        2
        4
        40 30 30 50
        15
        1 21 3 4 5 35 5 4 3 5 98 21 14 17 32

        T1  => 30+30 == 60, 60+40 == 100, 100+50 == 150 => 60+100+150 == 310
               40+30 == 70, 30+50 == 80, 70+80 == 150 => 70+80+150 == 300
               각 파일을 임시파일에 합치는 것보다 각 파일끼리 합치고 임시 파일을 합치는 것이 더 빠르다는 것?

    예제출력:
        300
        826
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Queue<Long> q = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");

            while (K-- > 0) {
                q.offer(Long.parseLong(st.nextToken()));
            }

            long count = 0;
            while (!q.isEmpty()) {
                long file = q.poll();

                if (q.isEmpty()) {  // 모두 합쳤을 때
                    sb.append(count).append('\n');
                    break;
                }
                long temp = file + q.poll();
                q.offer(temp);
                count += temp;
            }
        }

        System.out.println(sb);
        br.close();
    }

}