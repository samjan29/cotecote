class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // n이 홀수
        if (n % 2 != 0) {
            for (int i = 2; i < n; i++)
                if (n % i == 1) {
                    answer = i;
                    break;
                }
        // n이 짝수
        } else {    // 가까운 if가 바로 위의 if라서 한줄이라도 블럭을 사용해줘야 함
            for (int i = 3; i < n; i += 2)
                if (n % i == 1) {
                    answer = i;
                    break;
                }
        }
        
        return answer;
    }
}