class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer;
        
        int matchCount = 0, zeroCount = 0;
        int best = 0, low = 0;
        
        Loop:
        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCount++;
                continue;
            }
            
            for (int num : win_nums) {
                if (lotto == num) {
                    matchCount++;
                    continue Loop;
                }
            }
        }
        
        answer = new int[]{getRanking(matchCount + zeroCount), getRanking(matchCount)};
    
        return answer;
    }
    
    int getRanking(int count) {
        switch (count) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}