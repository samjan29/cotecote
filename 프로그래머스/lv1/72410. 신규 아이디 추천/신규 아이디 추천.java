class Solution {
    public String solution(String new_id) {
        // 1단계
        new_id = new_id.toLowerCase();
        
        // 2단계
        // 자바에서는 \\ 이렇게 두번 써야함
        new_id = new_id.replaceAll("[^a-z\\d-_.]", "");  // [^a-z0-9-_.] == [^a-z\\d-_.] 
        
        // 3단계
        new_id = new_id.replaceAll("[.][.]+", ".");   // [.]{2,} 이렇게도 쓸 수 있다!
        
        // 4단계  ^[.]|[.]$
        if (new_id.length() != 0) new_id = new_id.replaceAll("^[.]|[.]$", "");

        // 5단계
        if (new_id.equals("")) new_id = "a";
        
        // 6단계
        if (new_id.length() > 15) new_id = new_id.substring(0, 15);
        if (new_id.length() != 0 && new_id.charAt(new_id.length() - 1) == '.')
            new_id = new_id.replaceAll("^[.]|[.]$", "");

        // 7단계
        if (new_id.length() <= 2) {
            StringBuilder sb = new StringBuilder(new_id);
            
            while (sb.length() < 3)
                sb.append(Character.toString(new_id.charAt(new_id.length() - 1)));
            
            new_id = sb.toString();
        }

        return new_id;
    }
}

