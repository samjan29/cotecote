import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 레코드 분리 & 정렬 => 어떤 자료구조? TreeMap
        Map<String, List<String>> map = new TreeMap<>();
        splitRecord(map, records);
        
        // map value 가져고, 시간 계산하고, 정산해서, 알맞는 answer index에 재할당
        List<String> keySet = new ArrayList<>(map.keySet());
        int size = keySet.size();
        int[] answer = new int[size];
        
        for (int i = 0; i < size; i++) {
            List<String> list = map.get(keySet.get(i));
            
            // 정산    
            int useTime = getUseTime(list);
            
            if (useTime - fees[0] < 0) {
                answer[i] = fees[1];
            } else {
                int cumTime = useTime - fees[0];
                // 나누기할 때 형변환 하지 않아서 테스트 실패했었음
                double tmp = (double) cumTime / fees[2];
                cumTime = tmp % 1 == 0.0 ? (int) tmp
                    : (int) tmp + 1;
                
                answer[i] = fees[1] + cumTime * fees[3];
            }
            
        }
        
        return answer;
    }
    
    private void splitRecord(Map<String, List<String>> map, String[] records) {
        for (String record : records) {
            String[] array = record.split(" ");
            
            List<String> list = new ArrayList<>();
            String key = array[1];
            if (map.containsKey(key)) {
                list = map.get(key);
                list.add(array[0]);
            } else {
                list.add(array[0]);
                map.put(array[1], list);
            }
        }
    }
    
    private int getUseTime(List<String> list) {
        int useTime = 0;
        String[] in = {};
        
        for (int j = 0; j < list.size(); j++) {
            if (j % 2 == 0) {
                in = list.get(j).split(":");
                
                if (j == list.size() - 1) {
                    int hours = 23 - Integer.parseInt(in[0]);
                    int mins = 59 - Integer.parseInt(in[1]);
                    useTime += hours * 60 + mins;
                }
                
            } else {
                String[] out = list.get(j).split(":");
                int hours = Integer.parseInt(out[0]) - Integer.parseInt(in[0]);
                int mins = Integer.parseInt(out[1]) - Integer.parseInt(in[1]);
                useTime += hours * 60 + mins;
                
            }
            
        }
        return useTime;
    }
    
}