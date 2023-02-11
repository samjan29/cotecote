import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int solution(int[] array) {
//         if (array.length == 1) return array[0];
        
//         int[] arr = new int[1000];
        
//         // arr의 index가 array의 숫자 종류(?), arr[index]가 array의 각 숫자 개수
//         int max = 0, min = 999;
//         for (int num : array) {
//             arr[num]++; 
//             if (num > max) max = num;
//             if (num < min) min = num;
//         }
        
//         // array 길이는 1 초과인데 한가지 숫자로만 채워져있을 경우
//         if (max == min) return max;
        
//         // array 안의 가장 큰 숫자까지만 배열 자르기
//         arr = Arrays.copyOfRange(arr, 0, max + 1);
        
//         // 최빈값과 최빈값이 몇개가 들어있는지
//         int count = 0, mode = min;
//         for (int i = min; i < arr.length; i++) {                  
//             // array에서 나오지 않은 값은 건너뛰기
//             if (arr[i] == 0) continue;
            
//             // i == min일 때 count에 비교할 숫자가 없고 굳이 이 아래로 실행할 필요 없기 때문에
//             if (i == min) {
//                 count = arr[i];
//                 continue;
//             }
            
//             // 새로운(?) 최빈값을 찾았을 경우
//             if (arr[i] > count) {
//                 count = arr[i];
//                 mode = i;
//                 continue;
//             }
            
//             // 여기서 조건문 걸고 arr[mode] = 0으로 만들었을 때 안되는 이유
//             // 위의 arr[i] > count가 arr[arr.length - 1] > count면 arr[mode] = 0이 되지 못함
//         }
        
//         for (int i = 0; i < arr.length; i++) {
//             if (i != mode && arr[i] == count) return -1;
//         }
        
        
//         return mode;
        
        HashMap<Integer, Integer> map = new HashMap<>(array[array.length - 1]);

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) map.put(array[i], map.get(array[i]) + 1);
            else map.put(array[i], 1);
        }
        
        int nowNum = -1;
        int count = 0;
        for (int num : array) {
            if (nowNum == -1) {
                nowNum = num;
                count = map.get(nowNum);
                continue;
            } else if (nowNum == num) continue;
            
            if (map.get(num) > count) {
                nowNum = num;
                count = map.get(num);
            }
        }
        
        map.remove(nowNum);
        if (map.containsValue(count)) return -1;
        
        return nowNum;
    }
}