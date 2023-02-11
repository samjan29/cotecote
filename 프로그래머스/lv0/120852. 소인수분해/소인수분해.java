import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer = new int[20];
        
        int i = 2;
        int count = 0;
        while (n != 1) {
            if (n % i == 0) {
                n = n / i;
                if (answer[count] != i) {
                    answer[count] = i;
                }
            } else {
                if (answer[count] == i) count++;
                i++;
            }
            
        }
        
        answer = Arrays.copyOfRange(answer, 0, count + 1);
        
        return answer;
    }
}