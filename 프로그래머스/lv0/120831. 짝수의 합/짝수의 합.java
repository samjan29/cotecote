class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // for (int i = 0; i < n / 2; i++) {
        //     if (n % 2 == 0) {
        //         answer += n - 2 * i;
        //     } else {
        //         answer += n - 2 * i - 1;
        //     }
        // }
        
        for (int i = 1; i <= n / 2; i++) answer += i * 2;
        
        return answer;
    }
}
