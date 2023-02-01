package programmers.lv0;
// 2023. 01. 28
// 120825
public class 문자_반복_출력하기 {
    public String solution(String my_string, int n) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < my_string.length(); i++) {
            answer.append(Character.toString(my_string.charAt(i)).repeat(n));
        }

        return answer.toString();
    }
}
