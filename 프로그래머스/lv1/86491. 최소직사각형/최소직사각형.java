class Solution {
    public int solution(int[][] sizes) {
        int wMax = 0, hMax = 0;
        
        // 가로를 긴 길이로 바꾸기
        // for (int[] size : sizes) {
        //     if (size[0] < size[1]) {
        //         int tmp = size[0];
        //         size[0] = size[1];
        //         size[1] = tmp;
        //     }
        // }
        
        // 비교
//         for (int i = 0; i < sizes.length; i++) {
//             if (i == 0) {
//                 wMax = sizes[i][0];
//                 hMax = sizes[i][1];
//                 continue;
//             }
            
//             if (wMax < sizes[i][0]) wMax = sizes[i][0];
//             if (hMax < sizes[i][1]) hMax = sizes[i][1];
//         }
        
        for (int[] size : sizes) {
            wMax = Math.max(wMax, Math.max(size[0], size[1]));
            hMax = Math.max(hMax, Math.min(size[0], size[1]));
        }
        
        return wMax * hMax;
    }
}