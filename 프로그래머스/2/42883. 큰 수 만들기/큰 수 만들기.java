

class Solution {
    public String solution(String number, int k) {        
        StringBuilder sb = new StringBuilder();
        char[] arr = number.toCharArray();
        
        // number 중에 제거해야 하는 개수 k
        int len = arr.length - k;
        
        int idx = 0;
        
        for (int i = 0; i < len; i++) {
            char biggest = '0';
            
            for (int j = idx; j <= i + k; j++) {
                if (arr[j] > biggest) {
                    biggest = arr[j];
                    idx = j + 1;
                }
            }
            
            sb.append(Character.toString(biggest));
        }
        
        return sb.toString();
    }
}