class Solution {
    public String solution(String letter) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        StringBuffer sb = new StringBuffer();
        
        String[] strArr = letter.split(" ");
        for (int i = 0; i < strArr.length; i++) {
            for (int j = 0; j < morse.length; j++) {
                if (morse[j].equals(strArr[i])) {
                    sb.append((char) ('a' + j));
                    break;
                }
            }
        }
        
        return sb.toString();
    }
}