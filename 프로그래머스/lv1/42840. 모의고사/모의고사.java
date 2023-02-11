class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        // 수포자들
        int[] supoza1 = new int[]{1, 2, 3, 4, 5};
        int[] supoza2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] supoza3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        // 수포자들 맞춘 수 넣는 배열
        int[] correctCounts = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            // 수포자1
            if (supoza1[i % supoza1.length] == answers[i]) correctCounts[0]++;

            // 수포자2
            if (supoza2[i % supoza2.length] == answers[i]) correctCounts[1]++;
            
            // 수포자3
            if (supoza3[i % supoza3.length] == answers[i]) correctCounts[2]++;
        }
        
        if (correctCounts[0] > correctCounts[1] && correctCounts[0] > correctCounts[2]) answer = new int[]{1};
        else if (correctCounts[1] > correctCounts[0] && correctCounts[1] > correctCounts[2]) answer = new int[]{2};
        else if (correctCounts[2] > correctCounts[0] && correctCounts[2] > correctCounts[1]) answer = new int[]{3};
        else if (correctCounts[0] == correctCounts[1] && correctCounts[0] > correctCounts[2]) answer = new int[]{1, 2};
        else if (correctCounts[1] == correctCounts[2] && correctCounts[1] > correctCounts[0]) answer = new int[]{2, 3};
        else if (correctCounts[0] == correctCounts[2] && correctCounts[0] > correctCounts[1]) answer = new int[]{1, 3};
        else if (correctCounts[0] == correctCounts[1] && correctCounts[1] == correctCounts[2]) answer = new int[]{1, 2, 3};
        
        return answer;
    }
}