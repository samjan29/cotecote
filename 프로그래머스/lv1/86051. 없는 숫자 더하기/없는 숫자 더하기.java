import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {                
        int sum = 0, buff = 0;
        
        for (int i = 1; i <= 9; i++)
            sum += i;
        
        for (int i = 0; i < numbers.length; i++)
            buff += numbers[i];
        
        return sum - buff;
    }
}