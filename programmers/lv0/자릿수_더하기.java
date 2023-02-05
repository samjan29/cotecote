package programmers.lv0;
// 2023. 02. 05
// 120906

public class 자릿수_더하기 {
    public int solution(int n) {
        int answer = 0;

        while (n > 0) {
            answer += n % 10;
            n /= 10;
        }

        return answer;
    }
}
