class Solution {
    public String solution(String str1, String str2) {
        StringBuffer sb = new StringBuffer(str1.length() + str2.length());
        
        for (int i = 0; i < str1.length(); i++) {
            sb.append(str1.charAt(i));
            sb.append(str2.charAt(i));
        }
        
        return sb.toString();
    }
}