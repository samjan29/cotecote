class Solution {
    public int[] solution(String my_string) {
        StringBuilder sb = new StringBuilder(my_string.length());
        
        for (int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            if (ch >= '0' && ch <= '9') {
                sb.append(ch);
            }
        }
        
        String str = sb.toString();
        int[] answer = new int[str.length()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = str.charAt(i) - '0';
        }
        
        for (int i = 0; i < answer.length; i++) {
            for (int j = i + 1; j < answer.length; j++) {
                if (answer[i] > answer[j]) {
                    int temp = answer[i];
                    answer[i] = answer[j];
                    answer[j] = temp;
                }
            }
        }
        
        return answer;
    }
}