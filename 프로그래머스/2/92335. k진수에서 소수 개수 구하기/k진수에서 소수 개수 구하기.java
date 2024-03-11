class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String[] numbers = Integer.toString(n, k).split("0");
        for (String number : numbers) {
            if (number.equals("")) {
                continue;
            }
            
            if (isPrime(Long.parseLong(number))) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isPrime(long number) {
        if (number <= 1) return false;
        
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        
        return true;
    }
}