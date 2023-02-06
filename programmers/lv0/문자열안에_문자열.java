package programmers.lv0;
// 2023. 02. 06
// 120908
public class 문자열안에_문자열 {
    public int solution(String str1, String str2) {
        return str1.indexOf(str2) >= 0 ? 1 : 2;
    }
}
