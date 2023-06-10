class Solution {
    public String solution(String phone_number) {
        int len = phone_number.length();
        StringBuffer sb = new StringBuffer(len);
        sb.append("*".repeat(len - 4));
        sb.append(phone_number.substring(len - 4));
        
        return sb.toString();
    }
}