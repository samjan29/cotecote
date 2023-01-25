package year2023.month01;

import java.util.ArrayList;

public class Day25_1 {
    public ArrayList<Integer> solution(int n) {
        ArrayList<Integer> answer = new ArrayList<Integer>();

        for (int i = 1; i <= n; i += 2)
            answer.add(i);

        return answer;
    }
}
