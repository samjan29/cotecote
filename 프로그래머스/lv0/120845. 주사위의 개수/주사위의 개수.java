class Solution {
    public int solution(int[] box, int n) {
        int answer = 1;
        
        for (int corner : box) answer *= corner / n;
        
        return answer;
    }
}