package programmers.lv0;
// 2023. 01. 25
// 120813
import java.util.ArrayList;

public class 짝수는_싫어요 {
    public ArrayList<Integer> solution(int n) {
        ArrayList<Integer> answer = new ArrayList<Integer>();

        for (int i = 1; i <= n; i += 2)
            answer.add(i);

        return answer;
    }
}
