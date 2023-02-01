package programmers.lv0;
// 2023. 01. 22
// 120822
public class 문자열_뒤집기 {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        sb.append(my_string);
        sb.reverse();

        return sb.toString();
    }
}
