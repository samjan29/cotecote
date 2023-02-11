class Solution {
    public int solution(int slice, int n) {
        int answer = 0;
        
        if (n > slice) answer = (n / slice) + (n % slice == 0 ? 0 : 1);
        else answer = 1;
        
        return answer;
    }
}