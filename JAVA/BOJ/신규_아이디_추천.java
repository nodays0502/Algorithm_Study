package self;

public class 신규_아이디_추천 {
    StringBuilder sb = new StringBuilder();

    public String solution(String new_id) {
    //    System.out.println(new_id.toLowerCase());
        StringBuilder sb = new StringBuilder(new_id.toLowerCase()); // 1단계
        for(int i = 0 ; i < sb.length() ; i++){ // 2단계
            char temp = sb.charAt(i);
            if((temp >= 'a' && temp <= 'z') || 
               (temp >= '0' && temp <= '9') ||
               temp == '-' || temp == '_' || temp == '.'
              ){
                ;
            }else{
                sb.deleteCharAt(i);
                i--;
            }
        }
        boolean flag = false;
        for(int i = 0 ; i < sb.length() ; i++){ // 3단계
            char temp = sb.charAt(i);
            if(temp == '.'){
                if(flag){
                    sb.deleteCharAt(i);
                    i--;
                }
                flag = true;
            }else{
                flag = false;
            }
        }
        if(sb.charAt(0) == '.'){ // 4단계
            sb.deleteCharAt(0);
        }
        if(sb.length() >0 && sb.charAt(sb.length()-1) == '.'){ // 4단계
            sb.setLength(sb.length()-1);
        }
        if(sb.length() == 0){ // 5 단계
            sb.append('a');
        }
        if(sb.length() >= 16){ // 6 단계
            sb.setLength(15);
            if(sb.charAt(sb.length()-1) == '.'){ 
                sb.setLength(sb.length()-1);
            }
        }
        if(sb.length() <= 2 ){
            while(sb.length() < 3){
                sb.append(sb.charAt(sb.length()-1));
            }
        }
//        System.out.println(sb);
        String answer = sb.toString();
        return answer;
    }
}