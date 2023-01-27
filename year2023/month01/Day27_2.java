package year2023.month01;

public class Day27_2 {
    public String solution(String cipher, int code) {
        String answer = "";

        for (int i = code; i <= cipher.length(); i += code) {
            answer += cipher.charAt(i - 1);
        }

        return answer;
    }
}
