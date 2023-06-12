import java.util.Arrays;

class Solution {
    public String[] solution(String myString) {
        String[] answer = myString.split("[x]+");
        Arrays.sort(answer);
        return myString.charAt(0) == 'x' ? Arrays.copyOfRange(answer, 1, answer.length) : answer;
    }
}