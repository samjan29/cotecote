

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        // 성공률 오름차순 == 실패율 내림차순
        // answer에 스테이지 채우기
        for (int i = 0; i < answer.length; i++)
            answer[i] = i + 1;
        
        int[][] clear_arrival = new int[N][2];  // 0이 클리어 유저 수, 1이 도달 유저 수
        double[] successRates = new double[N];
        
        for (int i = 0; i < stages.length; i++) {
            for (int j = 0; j < stages[i]; j++) {
                // 스테이지 올 클리어 유저
                if (j == N) {   // N + 1은 없는 스테이지
                    clear_arrival[N - 1][0]++;  // index이기 때문
                    break;  // 굳이 증감식까지 진행할 이유가 없음
                }
                
                // 1 스테이지 트라이 중인 뉴비 == 클리어 스테이지X 유저
                if (j == 0) {
                    clear_arrival[j][1]++;
                    continue;
                }
                
                clear_arrival[j - 1][0]++;
                clear_arrival[j][1]++;
            }
        }
        
        // 성공률 구하기
        for (int i = 0; i < successRates.length; i++) {
            successRates[i] = (double) clear_arrival[i][0] / clear_arrival[i][1];
        }
        
        // 성공률 낮은 순으로 정렬 
        // (clear_arrival[i][1] == 0) == 실패율 0 -> 맨 뒤에 와야함
        for (int i = 0; i < answer.length; i++) {
            for (int j = i + 1; j < answer.length; j++) {
                // 도달한 사람이 없는 스테이지 실패율 0
                if (successRates[answer[i] - 1] == 0) {

                    if (answer[i] > answer[j]) {
                        int tmp = answer[i];
                        answer[i] = answer[j];
                        answer[j] = tmp;
                    }
                    
                } else if (successRates[answer[i] - 1] > successRates[answer[j] - 1]) {
                    int tmp = answer[i];
                    answer[i] = answer[j];
                    answer[j] = tmp;
                    
                } else if (successRates[answer[i] - 1] == successRates[answer[j] - 1]) {
                    
                    if (answer[i] > answer[j]) {
                        int tmp = answer[i];
                        answer[i] = answer[j];
                        answer[j] = tmp;
                    }
                    
                }
            }
        }
        
        return answer;
    }
}