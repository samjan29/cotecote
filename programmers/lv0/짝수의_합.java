package programmers.lv0;
// 2023. 01. 20
// 120831
class 짝수의_합 {
    public int solution(int n) {
        int answer = 0;

        // for (int i = 0; i < n / 2; i++) {
        //     if (n % 2 == 0) {
        //         answer += n - 2 * i;
        //     } else {
        //         answer += n - 2 * i - 1;
        //     }
        // }

        for (int i = 1; i <= n / 2; i++) answer += i * 2;

        return answer;
    }
}
