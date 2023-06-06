class Solution {
    public String solution(int age) {
        String[] strArray = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        
        String strAge = Integer.toString(age);
        StringBuffer sb = new StringBuffer(strAge.length());
        
        for (int i = 0; i < strAge.length(); i++) {
            sb.append(strArray[strAge.charAt(i) - '0']);
        }
        
        return sb.toString();
    }
}