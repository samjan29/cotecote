import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        // 내림차순 정렬
        Arrays.sort(targets, (o1, o2) -> {
            // 개구간 끝 시간이 같다면 개구간 시작 시간이 작은 순으로
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            
            return o1[1] - o2[1];
        });
        
        int beforeEnd = 0;
        for (int[] target : targets) {
            // 이전 개구간 끝보다 이번 개구간 시작이 크다면 (안겹친다면)
            if (beforeEnd <= target[0]) {
                beforeEnd = target[1];
                answer++;
            }
        }
        
        return answer;
    }
}