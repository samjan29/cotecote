package year2023.month01;

public class Day26_2 {
    public int solution(int hp) {
        int answer = 0;
        int[] ants = {5, 3, 1};

        for (int ant : ants) {
            answer += hp / ant;
            hp %= ant;
        }

        return answer;
    }
}
