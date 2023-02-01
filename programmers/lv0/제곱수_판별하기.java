package programmers.lv0;
// 2023. 01. 24
// 120909
public class 제곱수_판별하기 {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) return 1;
            else answer = 2;
        }

        return answer;
    }
}
