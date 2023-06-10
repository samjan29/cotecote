class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int[] answer = new int[intervals[0][1] - intervals[0][0] + 1 +
                              intervals[1][1] - intervals[1][0] + 1];
        
        System.arraycopy(arr, intervals[0][0], answer, 0, intervals[0][1] - intervals[0][0] + 1);
        System.arraycopy(arr, intervals[1][0], answer, intervals[0][1] - intervals[0][0] + 1, intervals[1][1] - intervals[1][0] + 1);
        
        return answer;
    }
}