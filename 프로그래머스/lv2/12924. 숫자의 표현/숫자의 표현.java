class Solution {
    public int solution(int n) {
        int answer = 1;
        
        int range = n % 2 == 0 ? n / 2 : n / 2 + 1;
        
        Loop:
        for (int i = 1; i <= range; i++) {
            int sum = i;
            for (int j = i + 1; j <= range; j++) {
                sum += j;
                
                if (sum > n) break;
                if (sum == n) {
                    answer++;
                    continue Loop;
                }
            }

        }
        
        return answer;
    }
}