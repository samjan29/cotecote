class Solution {
    public int solution(int a, int b) {
        int result1 = a * (int) (Math.pow(10, (int) Math.log10(b) + 1)) + b;
        int result2 = 2 * a * b;
        return result1 < result2 ? result2 : result1;
    }
}