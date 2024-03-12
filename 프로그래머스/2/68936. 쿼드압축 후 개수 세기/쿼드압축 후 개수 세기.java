class Solution {
    
    private static int[] answer;
    
    public int[] solution(int[][] arr) {
        answer = new int[2];
        
        dq(0, 0, arr.length, arr);
        
        return answer;
    }
    
    // 분할정복
    private static void dq(int x, int y, int size, int[][] arr) {
        // 해당 영역이 압축이 가능한지 확인
        if (check(x, y, size, arr)) {
            // 값이 0과 1밖에 없기 때문에
            answer[arr[x][y]]++;
            return;
        }
        
        // 4개의 영역으로 나뉘어서 확인
        // 정사각형이라 1차와 2차 길이가 같음 => size / 2하면 1/4
        dq(x, y, size / 2, arr);    // 1번
        dq(x + size / 2, y, size / 2, arr); // 2번
        dq(x, y + size / 2, size / 2, arr); // 3번
        dq(x + size / 2, y + size / 2, size / 2, arr);  // 4번
    }
    
    
    // 해당 영역이 모두 같은 숫자인지 확인
    // 첫번째 위치랑 다른 위치들 값 비교
    private static boolean check(int x, int y, int size, int[][] arr) {
        
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                
                if (arr[x][y] != arr[i][j]) {
                    return false;
                }
                    
            }
        }
        
        return true;
    }
    
}