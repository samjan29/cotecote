import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    
    static final int MAX_TIME = 24 * 60 + 10;
    
    public int solution(String[][] book_time) {
        int answer = 0;
        
        int[][] arr = new int[book_time.length][2];
        int[] timeLine = new int[MAX_TIME];
        
        for (int i = 0; i < book_time.length; i++) {
            String[] in = book_time[i][0].split(":");
            String[] out = book_time[i][1].split(":");
            arr[i][0] = Integer.parseInt(in[0]) * 60 + Integer.parseInt(in[1]);
            arr[i][1] = Integer.parseInt(out[0]) * 60 + Integer.parseInt(out[1]);
        }
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i][0]; j <= arr[i][1] + 9; j++) {
                timeLine[j]++;
            }
        }
        
        for (int i = 0; i < timeLine.length; i++) {
            answer = Math.max(answer, timeLine[i]);
        }
        
        return answer;
    }
}