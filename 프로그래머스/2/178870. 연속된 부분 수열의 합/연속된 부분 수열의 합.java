import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int[] solution(int[] seq, int k) {
        int len = seq.length;
        int left = 0;
        int right = seq.length;
        int sum = 0;
        
        // 처음에 sum을 0으로 되돌려서 그리디 탐색해서 시간초과로 실패했었음 n^2
        for (int l = 0, r = 0; l < len; l++) {
            while (r < len && sum < k) {
                sum += seq[r++];
            }
            
            if (sum == k) {
                if (right - left > r - l - 1) {    // R++이라서
                    left = l;
                    right = r - 1;
                }
            }
            
            sum -= seq[l];
        } 
        
        return new int[] {left, right};
    }
}