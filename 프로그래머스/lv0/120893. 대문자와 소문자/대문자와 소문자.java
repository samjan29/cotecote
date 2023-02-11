class Solution {
    public String solution(String my_string) {        
        char[] chArr = my_string.toCharArray();
        
        for (int i = 0; i < chArr.length; i++) {
            int gap = 'a' - 'A';
            
            if (chArr[i] >= 'a' && chArr[i] <= 'z') {
                chArr[i] -= gap;
            } else {
                chArr[i] += gap;
            }
        }
        
        return String.valueOf(chArr);
    }
}