package programmers.lv0;
// 2023. 01. 23
// 120585
public class 머쓱이보다_키_큰_사람 {
    public int solution(int[] array, int height) {
        int answer = 0;

        for (int num : array)
            if (num > height) answer++;

        return answer;
    }
}
