package programmers.lv0;
// 2023. 01. 27
// 120892
public class 암호_해독 {
    public String solution(String cipher, int code) {
        String answer = "";

        for (int i = code; i <= cipher.length(); i += code) {
            answer += cipher.charAt(i - 1);
        }

        return answer;
    }
}
