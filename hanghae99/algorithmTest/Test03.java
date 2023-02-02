package hanghae99.algorithmTest;

import java.util.Arrays;

public class Test03 {
        public char[][] solution(int N, char[][] ary) {
            int[] x = {1, -1, 0, 0, 1, 1, -1, -1};
            int[] y = {0, 0, 1, -1, 1, -1, 1, -1};

            char[][] answer = new char[N][N];

            for (int i = 0; i < answer.length; i++) {
                Loop:
                for (int j = 0; j < answer[i].length; j++) {
                    if (ary[i][j] >= '1' && ary[i][j] <= '9' ) {    // char 타입이기 때문에 10 이상이 값일리가 없음
                        answer[i][j] = '*';
                        continue;
                    }

                    if (answer[i][j] == Character.MIN_VALUE) answer[i][j] = '0';

                    for (int k = 0; k < x.length; k++) {
                        if (i + x[k] < 0 || j + y[k] < 0 || i + x[k] == N || j + y[k] == N) continue;

                        if (ary[i + x[k]][j + y[k]] >= '1' && ary[i + x[k]][j + y[k]] <= '9') {
                            answer[i][j] += ary[i + x[k]][j + y[k]] - '0';
                        }

                        if (answer[i][j] > '9') {
                            answer[i][j] = 'M';
                            continue Loop;
                        }
                    }

                }
            }

            return answer;
        }

        public static void main(String[] args) {
            Test03 method = new Test03();
            int N = 5;
            char[][] chars = {
                    {'1', '.', '.', '.', '.'},
                    {'.', '.', '3', '.', '.'},
                    {'.', '.', '.', '.', '.'},
                    {'.', '4', '.', '.', '.'},
                    {'.', '.', '.', '9', '.'}
            };
            System.out.println(Arrays.deepToString(method.solution(N, chars)));
            N = 4;
            chars = new char[][]{
                    {'2', '.', '.', '.'},
                    {'.', '.', '9', '.'},
                    {'.', '3', '.', '2'},
                    {'.', '4', '.', '.'}
            };
            System.out.println(Arrays.deepToString(method.solution(N, chars)));
        }
}
