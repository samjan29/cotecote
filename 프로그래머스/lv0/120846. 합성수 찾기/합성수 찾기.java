class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 1, 2, 3은 합성수 아님
        for (int i = 4; i <= n; i++) {
            int count = 0;
            
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) count++;
                else if (i % j == 0) count += 2;
            }
            
            if (count >= 3) answer++;
        }
        
        return answer;
    }
}