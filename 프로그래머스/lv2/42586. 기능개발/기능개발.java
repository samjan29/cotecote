import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        Integer[] boxedProgress = Arrays.stream(progresses).boxed().toArray(Integer[]::new);
        Queue<Integer> progressQueue = new LinkedList<>(Arrays.asList(boxedProgress));
        
        List<Integer> answer = new ArrayList<>();
        
        int index = 0;
        while (progressQueue.size() != 0) {
            for (int i = index; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }
            
            if (progresses[index] >= 100) {
                int count = 0;
                for (int i = index; i < progresses.length; i++) {
                    if (progresses[i] < 100) {
                        break;
                    }
                    
                    index++;
                    count++;
                    progressQueue.poll();
                }
                
                answer.add(count);
            }
        }
        
        return answer;
    }
}