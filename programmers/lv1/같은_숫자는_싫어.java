package programmers.lv1;
// 2023. 01. 27
// 12906
import java.util.*;

public class 같은_숫자는_싫어 {
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
