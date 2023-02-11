class Solution {
    public boolean solution(int x) {
        int sumX = 0;
        int tmp = x;
        while (tmp > 0) {
            sumX += tmp % 10;
            tmp /= 10;
        }
        
        return x % sumX == 0 ? true : false;
    }
}