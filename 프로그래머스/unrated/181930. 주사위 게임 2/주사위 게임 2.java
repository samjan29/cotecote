class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        
        int sum = a + b + c;
        
        if (sum % 3 == 0 && sum / 3 == a) {
            answer = (int) (Math.pow(sum, 3)) * (int) (Math.pow(a, 3));
        } else if (a != b && b != c && a != c) {
            answer = sum;
        } else {
            answer = sum * (a * a + b * b + c * c);
        }
        
        return answer;
    }
}