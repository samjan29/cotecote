package programmers.lv1;
// 2023. 01. 27
// 12931
public class 자릿수_더하기 {
    public int solution(int n) {
        int answer = 0;

        while (n != 0) {
            answer += n % 10;
            n /= 10;
        }

        return answer;
    }
}
