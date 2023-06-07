class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        int count = 0;
        
        Loop:
        for (int i = 0; i < delete_list.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == delete_list[i]) {
                    count++;
                    continue Loop;
                }
            }
        }
        
        int[] answer = new int[arr.length - count];
        
        int index = 0;
        
        Loop:
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < delete_list.length; j++) {
                if (arr[i] == delete_list[j])
                    continue Loop;
                else if (j == delete_list.length - 1)
                    answer[index++] = arr[i];
            }
        }
        
        return answer;
    }
}