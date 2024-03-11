import java.util.Stack;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        // 완전탐색(n^2) => 시간 초과로 실패! 최대 길이가 1,000,000
                
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(answer, -1);
        
        
        for (int i = 0; i < numbers.length; i++) {
            
            // stack이 비워져 있으면 while문을 돌릴 필요 X
            // stack 후입 값이 현재 탐색 값보다 작을 경우, 뒷 큰수를 찾은 경우
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                // 뒷 큰수를 찾은 인덱스는 stack에서 반환하면서 삭제하고 해당 위치에 뒷 큰수 저장
                answer[stack.pop()] = numbers[i];
            }
                
            // 언제 뒷 큰수가 나올지 모르기 때문에 stack을 계속 쌓는 것
            stack.push(i);
            
        }
        
        return answer;
    }
}