package year2023.month01;

public class Protractor19 {
    public int solution(int angle) {
        int answer = 0;

        if (angle <= 180 && angle > 0) {
            if (angle == 180) answer = 4;
            else if (angle < 180 && angle > 90) answer = 3;
            else if (angle == 90) answer = 2;
            else answer = 1;
        }

        return answer;
    }
}
