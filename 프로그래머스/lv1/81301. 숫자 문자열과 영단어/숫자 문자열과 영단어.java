class Solution {
    public int solution(String s) {
        String[] numToString = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for (int i = 0; i < numToString.length; i++) {
            if (s.contains(numToString[i])) {
                // replace 메서드 반환값 있음
                s = s.replace(numToString[i], String.valueOf(i));
            }
        }
        
        return Integer.parseInt(s);
    }
}