package programmers.lv0;
// 2023. 01. 22
// 120854
class 배열_원소의_길이 {
    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];

        for (int i = 0; i < strlist.length; i++)
            answer[i] = strlist[i].length();

        return answer;
    }
}
