class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];
        
        int[][] arr = new int[n][n];
        
        // 시작 지점
        int x = -1;
        int y = 0;
        
        // 지금 채울 숫자
        int currN = 1;
        
        // n만큼 꺾이기 때문에
        for (int i = 0; i < n; i++) {
            // 꺾일 때마다 채워야 하는 칸이 -1
            for (int j = 0; j < n - i; j++) {
                
                
                /*
                    시작이 1이 아니라 0이라서
                */
                // 왼쪽 대각선
                if (i % 3 == 0) {
                    x++;
                    
                // 가로
                } else if (i % 3 == 1) {
                    y++;
                    
                // 오른쪽 대각선
                } else if (i % 3 == 2) {
                    x--;
                    y--;
                }
                
                arr[x][y] = currN++;
                
            }
        }
        
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = arr[i][j];
            }
        }
               
        return answer;
    }
}