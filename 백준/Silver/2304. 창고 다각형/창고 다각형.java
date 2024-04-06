import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
    백준 2304번 창고 다각형
    분류: 브루트포스, 스택
    문제: 조건에 만족하는 지붕을 만들어서 가장 작은 창고의 크기를 구하라
        1.지붕은 수평 부분과 수직 부분으로 구성되며, 모두 연결되어야 한다.
        2.지붕의 수평 부분은 반드시 어떤 기둥의 윗면과 닿아야 한다.
        3.지붕의 수직 부분은 반드시 어떤 기둥의 옆면과 닿아야 한다.
        4.지붕의 가장자리는 땅에 닿아야 한다.
        5.비가 올 때 물이 고이지 않도록 지붕의 어떤 부분도 오목하게 들어간 부분이 없어야 한다.

    입력: 라인1 기둥의 수 N(1 <= N <= 1000)
        라인2부터 기둥의 왼쪽 상단 좌표 (L, H) (1 <= L,H <= 1000) => 정렬되어 있지 않음

        1000^3 == 10,0000,0000

    출력: 가장 작은 창고의 크기를 출력

    풀이: int[][] arr에 저장해서 x좌표인 arr[][0]으로 정하면서 가장 높은 높이를 구해놓기
        근데 가장 높은 기둥이 여러개일 수 있음...
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] LArr = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        int maxX = 0;
        for (int i = 0, max = 0; i < N; i++) {   // O(n + k)
            String[] split = br.readLine().split(" ");
            LArr[i] = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            map.put(LArr[i], y);
            if (max < y) {
                max = y;
                maxX = LArr[i];
            }
        }

        Arrays.sort(LArr);

        Stack<Integer> left = new Stack<>();
        for (int i = 0; i < LArr.length; i++) {
            if (LArr[i] == maxX) {
                break;
            }
            int y = map.get(LArr[i]);
            for (int j = 0; j < LArr[i + 1] - LArr[i]; j++) {
                if (!left.isEmpty() && left.peek() > y) {
                    left.push(left.peek());
                } else {
                    left.push(y);
                }
            }
        }

        Stack<Integer> right = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            if (LArr[i] == maxX) {
                break;
            }
            int y = map.get(LArr[i]);
            for (int j = 0; j < LArr[i] - LArr[i - 1]; j++) {
                if (!right.isEmpty() && right.peek() > y) {
                    right.push(right.peek());
                } else {
                    right.push(y);
                }
            }
        }

        int answer = map.get(maxX);
        while (!right.isEmpty() || !left.isEmpty()) {
            if (!right.isEmpty()) {
                answer += right.pop();
            }
            if (!left.isEmpty()) {
                answer += left.pop();
            }
        }

        System.out.println(answer);
        br.close();
    }

}