class Solution {
    public int solution(int num1, int num2) {
        if ((num1 >= 50000 && num1 <= -50000) && (num2 >= 50000 && num2 <= -50000)) return -1;
        
        return num1 + num2;
    }
}