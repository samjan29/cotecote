class Solution {
    static int[] discount = {10, 20, 30, 40};
    static int maxPeople = 0;
    static int maxProfit = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        
        int[] arr = new int[emoticons.length];
        
        comb(arr, 0, users, emoticons);
        
        answer[0] = maxPeople;
        answer[1] = maxProfit;
        
        return answer;
    }
    
    private void comb(int[] arr, int startIdx, int[][] users, int[] emoticons) {
        
        // 한가지 경우가 완성(?)될 때마다 계산
        if (startIdx == arr.length) {
            calculate(arr, users, emoticons);
            return;
        }
        
        // 모든 경우를 모두 탐색
        for (int i = 0; i < discount.length; i++) {
            arr[startIdx] = discount[i];
            comb(arr, startIdx + 1, users, emoticons);
        }
    }
    
    private void calculate(int[] arr, int[][] users, int[] emoticons) {
        
        // 해당 할인율을 적용했을 때 회원의 수
        int count = 0;
        // 해당 할인율을 적용했을 때 이익 
        int profit = 0;
        
        // 사용자마다 한 경우의 모든 확률로 계산
        for (int[] user : users) {
            int userPercent = user[0];
            int maxPrice = user[1];
            int sum = 0;
            
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= userPercent) {
                    sum += (emoticons[i] / 100) * (100 - arr[i]);
                }
            }
            
            // 사용자가 생각한 가격 이상이 된다면 이모티콘 플러스 정기 구독자
            if (sum >= maxPrice) {
                count++;
                
            // 아니면 이익에 추가
            } else {
                profit += sum;
            }
        }
        
        // 앞의 경우보다 더 1번 조건에 충족하면 변경
        if (count > maxPeople) {
            maxPeople = count;
            maxProfit = profit;
        
        // 앞의 1번 조건의 값과 같은데 이익이 큰 경우
        } else if (count == maxPeople) {
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
    }
    
}