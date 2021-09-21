class Solution {
    public int solution(String s) {
        int answer = 0;
        int num = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char now = s.charAt(i);
            // System.out.println(now);
            num *= 10;
            if(now >= '0' && now <='9'){
                num += now-'0';
            }
            else if(now == 'z'){ // 0
                i+=3;
            }else if(now == 'o'){ // 1
                num += 1;
                i+=2;
            }else if(now == 't'){ // 2,3
                char next = s.charAt(i+1);
                if(next == 'w'){
                    num += 2;
                    i+=2;
                }else{
                    num+=3;
                    i+=4;
                }
            }else if(now == 'f'){ // 4,5
                char next = s.charAt(i+1);
                if(next == 'o'){
                    num += 4;
                    i+=3;
                }else{
                    num+=5;
                    i+=3;
                }
            }else if(now == 's'){
                char next = s.charAt(i+1);
                if(next == 'i'){
                    num += 6;
                    i+=2;
                }else{
                    num+=7;
                    i+=4;
                }
            }else if(now == 'e'){
                num += 8;
                i+=4;
            }else{
                num += 9;
                i+= 3;
            }
        }
        answer = num;
        return answer;
    }
}
