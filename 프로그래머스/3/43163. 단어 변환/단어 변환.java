class Solution {
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        
        return answer;
    }
    
    public static void dfs(String begin, String target, String[] words, int count)  {
        if (begin.equals(target)) {
            answer = count;
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {
                continue;
            }
            
            // 같은 스펠링 수 확인
            int k = 0;
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    k++;
                }
            }
            
            // 한 번에 한 개의 알파벳만 바꿀 수 있기 때문에
            if (k == begin.length() - 1) {
                visited[i] = true;
                dfs(words[i], target, words, count + 1);
                visited[i] = false;
            }
            
        }
    }
    
}