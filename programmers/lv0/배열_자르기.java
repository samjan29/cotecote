package programmers.lv0;
// 2023. 01. 23
// 120833
public class 배열_자르기 {
    public int[] solution(int[] numbers, int num1, int num2) {
        int[] answer = new int[num2 - num1 + 1];

        int idx = 0;
        for (int i = num1; i <= num2; i++, idx++)
            answer[idx] = numbers[i];

        return answer;
    }
}
