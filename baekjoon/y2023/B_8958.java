package baekjoon.y2023;

import java.util.Arrays;

public class B_8958 {
    static int[] solution(int n, String[] array) {
        int[] answer = new int[n];

        char[][] charArr = new char[5][];

        for (int i = 0; i < charArr.length; i++) {
            charArr[i] = array[i].toCharArray();

            int sequence = 0;
            for (int j = 0; j < charArr[i].length; j++) {
                if (charArr[i][j] == 'X') sequence = 0;
                else {
                    answer[i] += sequence++ + 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] array = {"OOXXOXXOOO", "OOXXOOXXOO", "OXOXOXOXOXOXOX", "OOOOOOOOOO", "OOOOXOOOOXOOOOX"};
        System.out.println(Arrays.toString(solution(5, array)));
    }
}
