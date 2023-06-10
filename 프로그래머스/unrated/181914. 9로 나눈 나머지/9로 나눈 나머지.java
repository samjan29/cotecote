class Solution {
    public int solution(String number) {
        int answer = 0;
        
        if (number.length() <= 9) {
            answer = Integer.parseInt(number) % 9;
        } else {
            for (int i = 0; i < number.length(); i++) {
                answer += number.charAt(i) - '0';
            }
            answer %= 9;
        }
        
        return answer;
    }
}