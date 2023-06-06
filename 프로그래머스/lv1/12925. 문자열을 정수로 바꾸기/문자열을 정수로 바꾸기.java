class Solution {
    public int solution(String s) {
        int answer = 0;
        boolean prefix = true;
        
        for (int i = 0; i < s.length(); i++) {
            if (answer != 0) {
                answer *= 10;
            }
            
            switch (s.charAt(i)) {
                case '+':
                    break;
                case '-':
                    prefix = false;
                    break;
                default:
                    answer += s.charAt(i) - '0';
            }
        }
        
        return prefix ? answer : answer * -1;
    }
}