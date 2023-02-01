package programmers.lv0;
// 2023. 01. 24
// 120897
public class 약수_구하기 {
    public int[] solution(int n) {
        int[] answer;

        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) count++;
            else if (n % i == 0) count += 2;
        }

        answer = new int[count];

        count = 0;
        for (int i = 1; i <= n; i++)
            if (n % i == 0) {
                answer[count] = i;
                count++;
            }

        return answer;
    }
}
