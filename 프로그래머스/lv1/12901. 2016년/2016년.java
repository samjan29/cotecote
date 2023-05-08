import java.util.*;

class Solution {
    public String solution(int a, int b) {
        int[] lastDateInMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String[] dayOfWeek = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        
        int count = b;

        for (int i = 0; i < a - 1; i++) {
            count += lastDateInMonth[i];
        }
        
        return dayOfWeek[(count - 1) % 7];
    }
}