class Solution {
    public int solution(long num) {
        int answer = 0;
        
        // 오버플로우 발생
        long longNum = num;
        while(longNum != 1) {
            if (longNum % 2 == 0) longNum /= 2;
            else longNum = (longNum * 3) + 1;
            
            answer++;
            
            if (answer == 500) return -1;
        }
        
        return answer;
    }
}