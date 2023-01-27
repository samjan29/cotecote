package year2023.month01;

import java.util.*;

public class Day27_7 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        // map에 참여한 선수들의 이름과 이름이 같은 사람 수 세기
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String str : participant) {
            if (map.containsKey(str)) map.put(str, map.get(str) + 1);
            else map.put(str, 1);
        }

        // 완주한 사람 -1
        for (String str : completion) {
            map.put(str, map.get(str) - 1);
        }

        // 완주하지 못한 선수는 한명, value가 1인 사람 찾기
        for (String str : participant)
            if (map.get(str) == 1) return str;

        return answer;
    }
}
