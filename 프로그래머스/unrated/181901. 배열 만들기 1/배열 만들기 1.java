class Solution {
    public int[] solution(int n, int k) {
        int[] answer = new int[n / k];
        
        for(int i = 1, count = 0; i * k <= n; i++, count++) {
            answer[count] = i * k;
        }
        
        
        return answer;
    }
}