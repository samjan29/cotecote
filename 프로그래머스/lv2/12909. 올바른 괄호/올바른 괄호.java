import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char temp = s.charAt(i);
            
            if (temp == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
            
                stack.pop();
            }
        }
        
        return stack.isEmpty();    
    }
    
}