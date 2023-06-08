class Solution {
    public String solution(String[] seoul) {
        StringBuffer sb = new StringBuffer();
        sb.append("김서방은 ");
        
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                sb.append(i);
                break;
            }
        }
        
        sb.append("에 있다");
        
        return sb.toString();
    }
}