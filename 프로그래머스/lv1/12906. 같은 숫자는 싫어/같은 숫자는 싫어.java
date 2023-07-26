import java.util.Stack;

public class Solution {
    public Stack solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (!stack.empty() && stack.peek() == arr[i]) {
                continue;
            }
            
            stack.push(arr[i]);
        }
        
        
        return stack;
    }
}