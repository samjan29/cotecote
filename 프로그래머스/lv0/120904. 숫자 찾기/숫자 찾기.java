class Solution {
    public int solution(int num, int k) {
        int answer = -1;
        
        String strNum = Integer.toString(num);
        
        int len = strNum.length();
        for (int i = 0; i < len; i++) {
            if (strNum.charAt(i) - '0' == k) {
                answer = i + 1;
                break;
            }
        }
        
        return answer;
    }
}