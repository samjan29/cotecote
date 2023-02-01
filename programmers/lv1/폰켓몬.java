package programmers.lv1;
// 2023. 01. 30
// 1845
import java.util.HashMap;

public class 폰켓몬 {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        // nums.length / 2 만큼 폰켓몬을 가질 수 있다.
        for (int num : nums) {
            if (map.containsKey(num)) map.put(num, map.get(num) + 1);
            map.put(num, 1);
        }

        if (map.size() >= nums.length / 2) answer = nums.length / 2;
        else answer = map.size();

        return answer;
    }
}
