class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {-1};
        
        // 배열 길이 구하기
        int count = 0;
        for (int num : arr)
            if (num % divisor == 0) count++;

        // 나누어 떨어지는 element가 있다면
        if (count != 0) {
            answer = new int[count];
            
            count = 0;
            for (int i = 0; i < arr.length; i++)
                if (arr[i] % divisor == 0) answer[count++] = arr[i];
        }
        
        // answer 오름차순 정렬
        for (int i = 0; i < answer.length; i++)
            for (int j = i; j < answer.length; j++)
                if (answer[i] > answer[j]) {
                    int tmp = answer[i];
                    answer[i] = answer[j];
                    answer[j] = tmp;
                }
                
        
        return answer;
    }
}