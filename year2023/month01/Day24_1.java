package year2023.month01;

public class Day24_1 {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) return 1;
            else answer = 2;
        }

        return answer;
    }
}
