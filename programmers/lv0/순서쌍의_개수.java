package programmers.lv0;
// 2023. 01. 23
// 120836
public class 순서쌍의_개수 {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            // 변수 선언 & 초기화가 생각보다 오래 걸림
            if (n % i == 0) answer++;   // i가 n의 약수라면
        }

        return answer;
    }
}
