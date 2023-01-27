package year2023.month01;

public class Day27_11 {
    public int[] solution(long n) {
        int[] answer;

        // 배열의 길이를 구함
        long n2 = n;
        int count = 0;
        while (n2 > 0) {
            n2 /= 10;
            count++;
        }

        // n의 자릿수를 하나하나 받음
        answer = new int[count];

        // 신기하긴 한데 시간이 오래 걸림
        // String a = "" + n;
        // answer = new int[a.length()];

        for (int i = 0; i < answer.length; i++) {
            // n2 = n % 10;
            answer[i] = (int) (n % 10);
            n /= 10;
        }

        return answer;
    }
}
