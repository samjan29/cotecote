import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length];
        
        int count = 0, preNum = 0;
        for (int num : arr) {
            if (count == 0) {
                answer[count++] = num;
                preNum = num;
                continue;
            }
            
            if (num == preNum) {
                continue;
            } else {
                answer[count++] = num;
                preNum = num;
            }
        }

        return Arrays.copyOfRange(answer, 0, count);
    }
}