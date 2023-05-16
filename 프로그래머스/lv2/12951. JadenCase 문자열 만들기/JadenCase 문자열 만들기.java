class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        
        String[] strArr = s.split(" ");
        for (int i = 0; i < strArr.length; i++) {  
            if (strArr[i].equals("")) {
                sb.append(" ");
                continue;
            }
            
            char first = strArr[i].charAt(0);
            
            // 문자가 1글자 일 때
            if(strArr[i].length() == 1) {
                
                if (first >= 'a' && first <= 'z') {
                    sb.append(strArr[i].toUpperCase());
                } else {
                    sb.append(strArr[i]);
                }
                
            } else {
                
                if (first >= 'a' && first <= 'z') {
                    sb.append(strArr[i].substring(0, 1).toUpperCase());
                    sb.append(strArr[i].substring(1).toLowerCase());
                } else {
                    sb.append(strArr[i].substring(0, 1));
                    sb.append(strArr[i].substring(1).toLowerCase());
                }
            }
            
            // 단어일 경우 마지막에 띄어쓰기 or 마지막이 띄어쓰기일 경우
            if (i != strArr.length - 1 || s.charAt(s.length() - 1) == ' ') {
                sb.append(" ");
            }
        }
        
        return sb.toString();
    }
}