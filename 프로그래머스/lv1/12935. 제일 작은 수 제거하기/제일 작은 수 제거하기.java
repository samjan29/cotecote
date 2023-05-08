import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {-1};
        
        // !빈 배열 == 배열 길이가 2 이상
        if (arr.length != 1) {
            // 작은 수 찾기
            int minNum = 0;
            for (int i = 0; i < arr.length; i++) {
                if (i == 0) minNum = arr[i];
                if (minNum > arr[i]) minNum = arr[i];
            }
            
            // answer에 채워넣기
            answer = new int[arr.length - 1];
            for (int i = 0, idx = 0; i < arr.length; i++) {
                if (arr[i] == minNum) continue;
                answer[idx++] = arr[i];
            }
        }
        
        return answer;
    }
}