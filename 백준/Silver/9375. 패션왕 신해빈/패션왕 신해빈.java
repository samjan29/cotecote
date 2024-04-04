import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    백준 9375번 패션왕 신해빈
    분류 : 해시를 사용한 집합과 맵, 조합론
    조건 : 같은 조합은 한번만 가능. 알몸X(안경이나 모자 하나라도 걸쳐야 함)
           같은 종류의 의상은 하나만 입을 수 있음
    입력 : 테스트 케이스의 수 T (1 <= T <= 100)
           각 테스트 케이스의 의상 수 n (0 <= n <= 30)
           1 ~ 20자의 알파벳 소문자와 공백으로 구분되는 의상 이름과 의상 종류가 n개 주어짐 (중복되는 이름 X)
           e.g., hat headgear => 의상 이름 + ' ' + 의상 종류
    출력 : 서로 다른 옷의 조합의 수

    예제 입력
    2
    3
    hat headgear
    sunglasses eyewear
    turban headgear
    3
    mask face
    sunglasses face
    makeup face

    Test Case 1의 가능한 조합
    조합1: hat headgear
    조합2: sunglasses eyewear
    조합3: turban headgear
    조합4: hat headgear + sunglasses eyewear
    조합5: sunglasses eyewear + turban headgear

    hat headgear + turban headgear => 같은 종류라서 불가능한 조합

    Test Case 2의 가능한 조합
    조합1: mask face
    조합2: sunglasses face
    조합3: makeup face

    입력 받은 3가지 의상 모두 같은 종류이므로 조합이 불가능
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수
        int[] answer = new int[T]; // 각 테스트 케이스의 답

        Map<String, Integer> typeOfClothes = new HashMap<>();   // 의상 종류와 그 수를 담는 Map
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine()); // 의상 수
            while (n-- > 0) {
                String[] clothes = br.readLine().split(" ");
                typeOfClothes.put(clothes[1], typeOfClothes.getOrDefault(clothes[1], 0) + 1);
            }

            List<String> list = new ArrayList<>(typeOfClothes.keySet());
            int size = list.size();

            int combination = 1;
            for (int j = 0; j < size; j++) {
                combination *= typeOfClothes.get(list.get(j)) + 1; // +1을 하는 이유: 의상 종류별로 입지 않는 경우까지 포함
            }
            answer[i] = combination - 1; // -1을 하는 이유: 모두 입지 않는 경우는 제외
            typeOfClothes.clear();  // 다음 테스트 케이스를 위해 초기화
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}