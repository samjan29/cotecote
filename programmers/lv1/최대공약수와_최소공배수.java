package programmers.lv1;
// 2023. 01. 30
// 12940
public class 최대공약수와_최소공배수 {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        if (n > m) {
            answer[0] = gcd(n, m);
            answer[1] = (n / answer[0]) * (m / answer[0]) * answer[0];
        } else if (n < m) {
            answer[0] = gcd(m, n);
            answer[1] = (n / answer[0]) * (m / answer[0]) * answer[0];
        } else {
            answer[0] = n;
            answer[1] = n;
        }

        return answer;
    }

    int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }
}
