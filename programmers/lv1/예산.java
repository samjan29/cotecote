package programmers.lv1;
// 2023. 01. 30
// 12982
public class 예산 {
    public int solution(int[] d, int budget) {
        int answer = 0;

        for (int i = 0; i < d.length; i++)
            for (int j = i + 1; j < d.length; j++)
                if (d[i] > d[j]) {
                    int tmp = d[i];
                    d[i] = d[j];
                    d[j] = tmp;
                }

        int sumD = 0;
        while (sumD < budget) {
            if (answer == d.length) break;

            sumD += d[answer++];
        }

        return sumD > budget ? --answer : answer;
    }
}
