package programmers.lv0;
// 2023. 01. 30
// 120905
import java.util.ArrayList;
import java.util.List;

public class n의_배수_고르기 {
    public List<Integer> solution(int n, int[] numlist) {
        List<Integer> list = new ArrayList<>();

        for (int num : numlist)
            if (num % n == 0) list.add(num);

        return list;
    }
}
