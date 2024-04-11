import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    백준 8911번 거북이
    문제: 거북이 로봇을 움직인 경로를 포함할 수 있는 가장 작은 직사각형의 넓이를 구해라 => 가장 작으니까 주변부터 탐색(?) == bfs?
        그리고 거북이는 대각선으로 이동하지 않고 무조건 x축과 y축에 평행하게 움직인다.

    입력: 라인1 테스트 케이스 T
        라인2부터 테스트 케이스의 수만큼 한줄씩 위에 나와있는 4가지 명령어가 최대 500자 => 높이나 밑변이 최대 500으로 가장 큰 경우도 250 * 250 == 6,2500?

    출력: 거북이가 이동한 공간을 모두 포함할 수 있는 가장 작은 직사각형의 넓이

    풀이: # 거북이에게 내릴 수 있는 명령어 4가지
            F: 한 눈금 앞으로
            B: 한 눈금 뒤로
            L: 왼쪽으로 90도 회전
            R: 오른쪽으로 90도 회전

        변수는 현재 거북이가 보고 있는 방향이 어디인지,
            삼차원 정수 배열로 방향에 따라 어디로 어떻게 이동하는지 방향 벡터를 저장할 것

        그리고 가장 큰 x, y와 가장 작은 x, y로 직사각형의 높이와 밑변 크기를 구하고 곱해서 답을 구한다!

 */
public class Main {
    static int[][][] d = {
            {{0, 1}, {0, -1}},  // 위 전진, 후진
            {{1, 0}, {-1, 0}},  // 오른쪽 전진, 후진
            {{0, -1}, {0, 1}},  // 아래 전진, 후진
            {{-1, 0}, {1, 0}}   // 왼쪽 전진, 후진
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            char[] commands = br.readLine().toCharArray();
            int nd = 0;
            int maxX = 0, maxY = 0, minX = 0, minY = 0; // 0,0부터 시작이라서
            int[] now = new int[2];

            for (int i = 0; i < commands.length; i++) {
                int move = 0;
                switch (commands[i]) {
                    case 'B':
                        move = 1;
                        break;
                    case 'L':
                        if (nd == 0) {
                            nd = d.length - 1;
                        } else {
                            nd--;
                        }
                        continue;
                    case 'R':
                        if (nd == d.length - 1) {
                            nd = 0;
                        } else {
                            nd++;
                        }
                        continue;
                }

                now[0] += d[nd][move][0];
                now[1] += d[nd][move][1];

                if (((nd == 0 || nd == 1) && move == 0) || ((nd == 2 || nd == 3) && move == 1)) {
                    maxX = Math.max(maxX, now[0]);
                    maxY = Math.max(maxY, now[1]);
                } else {
                    minX = Math.min(minX, now[0]);
                    minY = Math.min(minY, now[1]);
                }

            }

            int x = maxX - minX;
            int y = maxY - minY;

            sb.append(x * y).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

}