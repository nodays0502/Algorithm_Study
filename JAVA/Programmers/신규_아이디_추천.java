class Solution {
    public String solution(String new_id) {
        String answer = "";
        StringBuilder sb= new StringBuilder(new_id.toLowerCase()); // 1단계
        // System.out.println(sb.toString());
        for(int i = sb.length()-1; i>=0 ; i--){ // 2단계
            char now = sb.charAt(i);
            if(!((now >= 'a' && now <= 'z') || (now >= '0' && now <= '9')|| now == '-' || now == '_' || now == '.')){
                sb.deleteCharAt(i);
            }
        }
        // System.out.println(sb.toString());
        boolean flag = false;
        for(int i = sb.length()-1; i>=0 ; i--){ // 3단계
            char now = sb.charAt(i);
            if(now == '.'){
                if(flag){
                    sb.deleteCharAt(i);
                }else{
                    flag = true;
                }
            }else{
                flag = false;
            }
        }
        // System.out.println(sb.toString());
        if(sb.charAt(sb.length()-1) == '.'){ // 4단계
            sb.deleteCharAt(sb.length()-1);
        }
        if(sb.length() > 0 && sb.charAt(0) == '.'){
            sb.deleteCharAt(0);
        }
        // System.out.println(sb.toString());
        if(sb.length() == 0){ // 5단계
            sb.append('a');
        }
        // System.out.println(sb.toString());
        if(sb.length() >= 16){ // 6단계
            sb.setLength(15);
        }
        if(sb.charAt(sb.length()-1) == '.'){ 
            sb.deleteCharAt(sb.length()-1);
        }
        // System.out.println(sb.toString());
        if(sb.length() <= 2){ // 7단계
            while(sb.length() <3){
                sb.append(sb.charAt(sb.length()-1));
            }
        }
        answer = sb.toString();
        return answer; 
    }
}
