class Solution {
    public int solution(String myString, String pat) {
        StringBuilder sb = new StringBuilder(myString.length());
        
        for (int i = 0; i < myString.length(); i++) {
            sb.append(myString.charAt(i) == 'A' ? "B" : "A");
        }
        
        return sb.toString().contains(pat) ? 1 : 0;
    }
}