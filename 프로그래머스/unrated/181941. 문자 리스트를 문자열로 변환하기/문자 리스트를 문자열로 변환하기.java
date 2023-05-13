class Solution {
    public String solution(String[] arr) {
        StringBuilder sb = new StringBuilder(arr.length);
        
        for(String str : arr) {
            sb.append(str);
        }
        
        return sb.toString();
    }
}