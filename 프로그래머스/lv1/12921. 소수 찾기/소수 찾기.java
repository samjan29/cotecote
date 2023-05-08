import java.util.ArrayList;

class Solution {
    public int solution(int n) {
        ArrayList<Boolean> primeList = new ArrayList<>(n + 1);   // n + 1만큼 할당 => index 0부터 시작하기 때문
        int answer = 0;
        
        // 0, 1을 소수 아님으로
        primeList.add(false);
		primeList.add(false);
        
        // 2부터 n까지 소수로 설정
        for (int i = 2; i <= n; i++) primeList.add(i, true);
        
        // 2, 3은 소수! 2, 3의 배수들과 소수가 아닌 수들 지우기
        for (int i = 2; i * i <= n; i++) {
            if (primeList.get(i)) {
                // i * i 미만 값은 이미 처리된 상태라서 j = i * i
                for (int j = i * i; j <= n; j += i) primeList.set(j, false);
            }
        }
        
        for (int i = 2; i <= n; i++)
            if (primeList.get(i)) answer++;
        
        return answer;
    }
}