import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
    백준 1863번 스카이라인 쉬운거
    분류: 스택
    문제: 스카이라인(해가 질때 보이는 건물의 윤곽? 그림자?)를 보고 건물이 최소 몇채인지 알아내자.

    입력: 라인1 왼쪽부터 스카이라인의 고도가 바뀌는 지점의 개수 n(1 ≤ n ≤ 5,0000)
        라인2부터 스카이라인 왼쪽부터 봤을 때 => 항상 x1 < x2 라는 것?
                y가 바뀌는 지점 (x, y) n개가 입력 (1 ≤ x ≤ 100,0000, 0 ≤ y ≤ 50,0000)

    출력: 최소 건물의 수

    풀이: 다음 높이보다 마지막 높이가 크면 count + 1하고 마지막 높이 제거
        같은 높이가 나왔을 때 다음 높이가 같으면 보류...
        다음 높이가 0이면 stack 모두 비우고 cou t + 1
        점을 모두 확인했을 경우 stack이 남아있다면 모든 높이를 stack에서 제거하면서 + 1

    예제입력:
        10
        1 1
        2 2
        5 1
        6 3
        8 1
        11 0
        15 2
        17 3
        20 2
        22 1

..........................  ..........................  ..........................  ..........................
.....XX.........XXX.......  .....22.........333.......  .....XX.........XXX.......  .....XX.........XXX.......
.XXX.XX.......XXXXXXX.....  .111.22.......XX333XX.....  .XXX.XX.......5555555.....  .XXX.XX.......XXXXXXX.....
XXXXXXXXXX....XXXXXXXXXXXX  X111X22XXX....XX333XXXXXXX  4444444444....5555555XXXXX  XXXXXXXXXX....666666666666

    예제출력:
        6
 */
public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int count = 0;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            st.nextToken();
            int y = Integer.parseInt(st.nextToken());


            while (!stack.isEmpty() && stack.peek() > y) {  // y보다 크면 같은 값이 다시 나왔을 경우 새로운 건물이기 때문에, y == 0일 때도 마찬가지
                count++;
                stack.pop();
            }

            if (!stack.isEmpty() && stack.peek() == y) {    // 같은 높이의 건물이 나왔다면 건너뛰기
                continue;
            }

            while (y == 0 && !stack.isEmpty()) {
                count++;
                stack.pop();
            }

            if (y == 0) {
                continue;
            }

            stack.push(y);
        }

        while (!stack.isEmpty()) {  // stack이 아직 남아있다면
            count++;
            stack.pop();
        }

        System.out.println(count);
        br.close();
    }

}