class Solution {
    public int solution(int n) {
        // 3진법 : 1 => 1, 10 => 3, 100 => 9, 1000 => 27
        String ternary = Integer.toString(n, 3);
        String reverseTernary = new StringBuilder(ternary).reverse().toString();        
        return Integer.parseInt(reverseTernary, 3);
    }
}