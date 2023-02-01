package programmers.lv0;
// 2023. 01. 22
// 120583
public class 중복된_숫자_개수 {
    public int solution(int[] array, int n) {
        int answer = 0;

        for (int num : array)
            if (num == n) answer++;

        return answer;
    }
}
