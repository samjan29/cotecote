import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {        
        for(int i = 0; i < num_list.length; i++) {
            for(int j = i + 1; j < num_list.length; j++) {
                if(num_list[i] > num_list[j]) {
                    int tmp = num_list[i];
                    num_list[i] = num_list[j];
                    num_list[j] = tmp;
                }
            }
        }
        
        return Arrays.copyOfRange(num_list, 5, num_list.length);
    }
}