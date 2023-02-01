package programmers.lv1;
// 2023. 01. 30
// 77884
public class 약수의_개수와_덧셈 {
    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            if (i % Math.sqrt(i) == 0) answer -= i;
            else answer += i;
        }

        return answer;
    }
}
