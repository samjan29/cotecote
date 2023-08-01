class Solution {
    public String solution(String s) {
        int halfOfSLen = s.length() / 2;
        return s.length() % 2 == 0 ? s.substring(halfOfSLen - 1, halfOfSLen + 1) : s.substring(halfOfSLen, halfOfSLen + 1);
    }
}