class Solution {
    public int solution(int[][] arr) {
        int answer = 1;
        
        Loop:
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != arr[j][i]) {
                    answer = 0;
                    break Loop;
                }
            }
        }
        
        return answer;
    }
}