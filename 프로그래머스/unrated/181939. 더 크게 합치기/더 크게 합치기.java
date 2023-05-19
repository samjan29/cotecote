class Solution {
    public int solution(int a, int b) {
        int ab = (int) (a * Math.pow(10, String.valueOf(b).length())) + b;
        int ba = (int) (b * Math.pow(10, String.valueOf(a).length())) + a;
        
        return ab > ba ? ab : ba;
    }
}