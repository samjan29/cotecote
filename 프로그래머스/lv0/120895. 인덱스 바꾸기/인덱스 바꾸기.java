class Solution {
    public String solution(String my_string, int num1, int num2) {
        char[] charArr = my_string.toCharArray();
        
        char temp = charArr[num1];
        charArr[num1] = charArr[num2];
        charArr[num2] = temp;
        
        return new String(charArr);
    }
}