package programmers.lv0;
// 2023. 01. 26
// 120837
public class 개미_군단 {
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
