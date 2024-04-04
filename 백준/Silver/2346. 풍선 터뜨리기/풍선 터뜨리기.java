import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
    백준 2346번 풍선 터뜨리기
    분류: 덱
    문제: N개의 풍선이 원형으로 놓여있다.
        각 풍선에는 정수가 적힌 번호가 들어있다. -N<=정수<=N
        풍선을 터뜨리고, 풍선 안의 숫자만큼 왼쪽이나 오른쪽으로 이동한다.
        +면 오른쪽(1보다 큰 쪽)으로, -면 왼쪽(1보다 작은 쪽)으로 이동한다.
    조건: 1번 풍선부터 시작

    입력: 풍선의 개수 N (1<=N<=1000)
        1번부터 N번까지 풍선에 적힌 정수 (최소 -1000, 최대 1000, 정수!=0)
    출력: 터진 순서의 번호를 순서대로 출력

    풀이: 덱 2개를 이용해서 풍선에 적힌 정수를 저장하고, 풍선 번호를 저장

    예제 입력:
        5
        3 2 1 -3 -1

        1번 풍선 터트리고 move 3 앞에서 제거, loc 1 앞에서 제거하고 출력    move = {2, 1, -3, -1}  loc = {2, 3, 4, 5}
        3 - 1(앞에 풍선을 제거해서)만큼 앞에서 제거 후 뒤에서 삽입          move = {-3, -1, 2, 1}  loc = {4, 5, 2, 3}
        4번 풍선 터트리고 move -3 앞에서 제거, loc 4 앞에서 제거하고 출력  move = {-1, 2, 1}  loc = {5, 2, 3}
        3(-3)만큼 뒤에서 제거 후 앞에서 삽입                           move = {-1, 2, 1}  loc = {5, 2, 3}
        5번 풍선 터트리고 move -1 앞에서 제거, loc 5 앞에서 제거하고 출력  move = {-1, 2}  loc = {2, 3}
        1(-1)만큼 뒤에서 제거 후 앞에서 삽입                           move = {2, -1}  loc = {3, 2}
        3번 풍선 터트리고 move 2 앞에서 제거, loc 3 앞에서 제거하고 출력    move = {-1}  loc = {2}
        하나만 남아서 2 이동해도 제자리 move -1 제거, loc 2 제거하고 출력    move = {2}  loc = {3}
    예제 출력:
        1 4 5 3 2
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 풍선의 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> move = new ArrayDeque<>();    // 풍선에 적힌 정수를 저장할 덱
        Deque<Integer> loc = new ArrayDeque<>();     // 풍선 번호를 저장할 덱
        for (int i = 1; i <= N; i++) {  // O(2000)
            move.add(Integer.parseInt(st.nextToken())); // O(1000)
            loc.add(i); // O(1000)
        }

        StringBuilder sb = new StringBuilder();
        while (!move.isEmpty()) {
            int m = move.pollFirst();   // 풍선에 적힌 정수
            int l = loc.pollFirst();    // 풍선 번호
            sb.append(l).append(" ");   // 풍선 번호 출력
            if (move.isEmpty()) break;  // 마지막 풍선이면 종료
            if (m > 0) {    // 오른쪽으로 이동
                for (int i = 0; i < m - 1; i++) {
                    move.addLast(move.pollFirst());
                    loc.addLast(loc.pollFirst());
                }
            } else {    // 왼쪽으로 이동
                for (int i = 0; i < Math.abs(m); i++) {
                    move.addFirst(move.pollLast());
                    loc.addFirst(loc.pollLast());
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}