class Solution {
    public int solution(int n) {
        int answer;
        
        if (n % 6 == 0) answer = n / 6;
        else {
            answer = n / gcd(n, 6); // n * 6 / gcd(n, 6) / 6;
        }
        
        return answer;
    }
    
    int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }
}