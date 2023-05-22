class Solution {
    public double solution(int[] arr) {
        int sum = 0;
        for (int number : arr) {
            sum += number;
        }
        
        return sum / (double) arr.length;
    }
}