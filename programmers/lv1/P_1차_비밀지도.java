package programmers.lv1;
// 2023. 01. 31
// 17681
public class P_1차_비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < arr1.length; i++) {
            StringBuilder binaryString1 = new StringBuilder(Integer.toBinaryString(arr1[i]));
            StringBuilder binaryString2 = new StringBuilder(Integer.toBinaryString(arr2[i]));

            if (binaryString1.length() < n)
                binaryString1.insert(0, "0".repeat(n - binaryString1.length()));

            if (binaryString2.length() < n)
                binaryString2.insert(0, "0".repeat(n - binaryString2.length()));

            StringBuilder sb = new StringBuilder(n);

            for (int j = 0; j < binaryString1.length(); j++) {
                if (binaryString1.charAt(j) == '1' || binaryString2.charAt(j) == '1') sb.append("#");
                else sb.append(" ");
            }

            answer[i] = sb.toString();
        }

        return answer;
    }
}
