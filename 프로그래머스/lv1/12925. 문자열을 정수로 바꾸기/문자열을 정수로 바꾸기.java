class Solution {
    public int solution(String s) {
        int answer = 0;
        int prefix = 1;
        
        for (int i = 0; i < s.length(); i++) {
            if (answer != 0) {
                answer *= 10;
            }
            
            switch (s.charAt(i)) {
                case '+':
                    break;
                case '-':
                    prefix = -1;
                    break;
                default:
                    answer += s.charAt(i) - '0';
            }
        }
        
        return answer * prefix;
    }
}