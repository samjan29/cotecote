import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        // 배열 자르기
        for (int i = 0; i < commands.length; i++) {
            int[] tmpArr = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
        
            // 배열 정렬
            for (int j = 0; j < tmpArr.length; j++)
                for (int k = j + 1; k < tmpArr.length; k++)
                    if (tmpArr[j] > tmpArr[k]) {
                        int tmp = tmpArr[j];
                        tmpArr[j] = tmpArr[k];
                        tmpArr[k] = tmp;
                    }

            // commands[i][2]번째 찾아서 answer[i]에 저장
            answer[i] = tmpArr[commands[i][2] - 1];
        }
        
        return answer;
    }
}