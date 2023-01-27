package year2023.month01;

public class Day27_3 {
    public int solution(int order) {
        int answer = 0;

        while (order > 2) {
            if ((order % 10) % 3 == 0) answer++;
            order /= 10;
        }

        return answer;
    }
}
