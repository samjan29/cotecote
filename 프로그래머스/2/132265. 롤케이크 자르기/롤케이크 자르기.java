import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> che = new HashMap<>();
        Set<Integer> bro = new HashSet<>();
        
        for (int t : topping) {
            // getOrDefault 가져오거나 초기화하거나
            che.put(t, che.getOrDefault(t, 0) + 1);
        }
        
        for (int t : topping) {
            // 동생이 t 토핑이 올라간 조각을 가져가면 철수 몫에서 빼기
            bro.add(t);
            che.put(t, che.get(t) - 1);
            
            // 철수에게 더 이상 해당 토핑이 없다면 map에서 제거
            if (che.get(t) == 0) {
                che.remove(t);
            }
            
            if (che.size() == bro.size()) {
                answer++;
            }

        }
        
        return answer;
    }
}