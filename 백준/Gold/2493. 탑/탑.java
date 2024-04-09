import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
    백준 2493번 탑
    분류: 스택
    문제: 왼쪽 수평으로 레이저를 발사하는 탑들이 일직선 위에 세워져있다.
        발사된 레이저 신호는 가장 먼저 만나는 탑 하나에만 송신된다.
        어떤 탑에서 발사한 레이저가 몇번째 탑에서 송신하는지 출력하라.

    입력: 라인1 탑의 개수 N(1 <= N <= 50,0000)
        라인2부터 N개의 탑의 높이가 한줄씩 입력 (1 <= 탑의 높이 <= 1,0000,0000)

    출력: 발사한 레이저가 몇번째 탑에서 송신하는지, 레이저를 송신하는 탑이 없다면 0
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int tower = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                if (tower <= stack.peek()[0]) { // 지금 탑보다 앞의 탑의 높이가 더 높으면 앞의 탑 위치를 출력
                    sb.append(stack.peek()[1]).append(' ');
                    break;
                }
                stack.pop();     // 지금 탑보다 앞의 탑의 높이가 작으면 빼고
            }

            if (stack.isEmpty()) {
                sb.append(0).append(' ');
            }

            stack.push(new int[]{tower, i});    // 일단 넣고
        }

        System.out.println(sb);
        br.close();
    }

}