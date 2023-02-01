package programmers.lv0;
// 2023. 01. 28
// 120851
public class 숨어있는_숫자의_덧셈_1 {
    public int solution(String my_string) {
        int answer = 0;

        for (int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            if (ch >= '1' && ch <= '9') {
                answer += ch - '0';
            }
        }

        return answer;
    }
}
