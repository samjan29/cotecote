class Solution {
    public int solution(String word) {   
        int answer = 0;
        
        int wordLen = word.length();
        for (int i = 0; i < wordLen; i++) {
            int dicIdx;
            switch (word.charAt(i)) {
                case 'A':
                    dicIdx = 0;
                    break;
                case 'E':
                    dicIdx = 1;
                    break;
                case 'I':
                    dicIdx = 2;
                    break;
                case 'O':
                    dicIdx = 3;
                    break;
                default:
                    dicIdx = 4;
            }
            
            int apIdx = wordLen < 5 ? 5 - 1 - i : wordLen - 1 - i; 
            
            answer += getCommonRatio(apIdx, dicIdx);
        }
        
        return answer;
    }
    
    private int getCommonRatio(int apIdx, int dicIdx) { 
        if (dicIdx == 0) return 1;
        // 재귀가 끝날 때는 곱하지 않고 사전 순서 인덱스 값 더하기
        if (apIdx == 0) return 1 + dicIdx;
        
        // 재귀 호출할 때는 사전 순서 인덱스 값 곱하기
        return (int) Math.pow(5, apIdx) * dicIdx + getCommonRatio(apIdx - 1, dicIdx);
    }
}