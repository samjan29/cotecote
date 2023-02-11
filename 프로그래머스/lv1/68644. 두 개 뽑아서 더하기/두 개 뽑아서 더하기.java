import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[500];
        
        int count = 0;
        for (int i = 0; i < numbers.length; i++)
            Loop:
            for (int j = i + 1; j < numbers.length; j++) {
                // 처음 시작
                if (i == 0 && j == 1) {
                    answer[count++] = numbers[i] + numbers[j];
                    continue;
                } 
                
                // 이미 있는 결과값인지 확인
                // 여기서 foreach로 돌렸을 때 배열 길이가 길어 
                // 초기화값과 비교해보고 0 + 0 일 때 넘겨버려 테스트8 통과 못했고
                // fori로 변경한 후 count + 1을 했는데 내가 값을 넣은 공간보다 한 칸 더 보는 것이라
                // 0이 있어서 통과 못해서 count + 1 -> count로 바꿔줘서 통과
                for (int k = 0; k < count; k++)
                    if (numbers[i] + numbers[j] == answer[k]) continue Loop;
                
                answer[count++] = numbers[i] + numbers[j];
            }
        
        // 필요 없는 인덱스 자르기
        answer = Arrays.copyOfRange(answer, 0, count);
        
        // 오름차순 정렬
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