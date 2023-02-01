package programmers.lv0;
// 2023. 01. 30
// 120845
public class 주사위의_개수 {
    public int solution(int[] box, int n) {
        int answer = 1;

        for (int corner : box) answer *= corner / n;

        return answer;
    }
}
