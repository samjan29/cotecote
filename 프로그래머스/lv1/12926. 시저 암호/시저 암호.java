class Solution {
    public String solution(String s, int n) {
        char[] chArr = s.toCharArray();
        
        for (int i = 0; i < chArr.length; i++) {
            if (chArr[i] != ' ') {
                char tmp = (char) (chArr[i] + n);
                
                if (tmp > 'z' && (chArr[i] >= 'a' && chArr[i] <= 'z')) {
                    chArr[i] = (char) (tmp - ('z' - 'a' + 1));
                    continue;
                } else if (tmp > 'Z' && (chArr[i] >= 'A' && chArr[i] <= 'Z')) {
                    chArr[i] = (char) (tmp - ('Z' - 'A' + 1));
                    continue;
                }
                
                chArr[i] = tmp;
            }
        }
        
        return String.valueOf(chArr);
    }
}