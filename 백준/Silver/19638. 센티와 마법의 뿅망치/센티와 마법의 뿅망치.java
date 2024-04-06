import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/*
    백준 19638번 센티와 마법의 뿅망치
    분류: 구현, 우선순위 큐
    문제: 뿅망치에 맞은 사람이 키 / 2로 키가 변한다. 단, 키가 1이면 변하지 않는다.
        뿅망치는 횟수 제한이 있어서 매번 키가 가장 큰 거인 중 하나를 때리는 것

    입력: 라인1 거인의 나라의 인구수 N(1 ≤ N ≤ 10,0000)
            센티의 키를 나타내는 정수 Hcenti(1 ≤ Hcenti ≤ 2 × 10,0000,0000)
            마법의 뿅망치의 횟수 제한 T (1 ≤ T ≤ 10,0000)
        라인2부터 N명의 거인들의 키 H가 한줄씩 입력됨 (1 ≤ H ≤ 2 × 10,0000,0000)

    출력: 모든 거인의 키가 센티보다 작다면 "YES"하고 두번째 줄에 뿅망치를 최소로 사용한 횟수
        아니라면 "NO"하고 두번째 줄에 가장 큰 거인의 키

    풀이: 우선순위 큐에 내림차순으로 거인의 모든 키를 담고
        뿅망치 횟수 만큼 1/2로 줄인 다음에
        맨 앞에 있는 거인의 키가 센티보다 작은지 확인하고 출력 조건에 따라 출력!
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int centiH = Integer.parseInt(split[1]);
        int T = Integer.parseInt(split[2]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int use = -1;
        for (int i = 0; i < T; i++) {
            int peek = pq.peek();
            if (peek == 1 || peek < centiH) {
                break;
            }
            pq.add(pq.poll() / 2);
            use = i;
        }

        int peek = pq.peek();
        if (peek < centiH) {
            System.out.println("YES");
            System.out.println(use != -1 ? use + 1 : 0);
        } else {
            System.out.println("NO");
            System.out.println(peek);
        }

        br.close();
    }

}