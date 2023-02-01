package programmers.lv0;
// 2023. 01. 27
// 120891
public class P_369게임 {
    public int solution(int order) {
        int answer = 0;

        while (order > 2) {
            if ((order % 10) % 3 == 0) answer++;
            order /= 10;
        }

        return answer;
    }
}
