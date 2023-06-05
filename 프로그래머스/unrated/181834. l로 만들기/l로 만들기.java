class Solution {
    public String solution(String myString) {
        for (int i = 0; i < myString.length(); i++) {
            if (myString.charAt(i) < 'l') {
                myString = myString.replaceAll(Character.toString(myString.charAt(i)), "l");
            }
        }
        
        return myString;
    }
}