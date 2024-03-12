import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        // 메인 레일에서 빠진 택배상자의 번호와 택배 기사가 요구하는 목록의 인덱스를 구분해야만
        // List 추가해서 이미 있는 택배박스는 거르려고 했지만 시간 초과!
        int idx = 0;
        for (int i = 1; i <= order.length; i++) {
            
            if (order[idx] != i) {
                stack.push(i);
            } else {
                idx++;
                answer++;
            }
            
            while (!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                idx++;
                answer++;
            }
            
        }
        
        return answer;
    }
}