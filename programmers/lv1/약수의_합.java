package programmers.lv1;
// 2023. 01. 30
// 12928
public class 약수의_합 {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i * i <= n; i++)
            if (i * i == n) answer += i;
            else if (n % i == 0) {
                answer += i + (n / i);
            }

        return answer;
    }
}
