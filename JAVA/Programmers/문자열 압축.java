import java.util.*;
class Solution {
    public int mkShort(String s,int size){
        int result = s.length();
        boolean flag = false;
        int cnt = 1;
        for(int i = 0 ; i+2*size+2 <= s.length() ; i++){
            String temp1 = s.substring(i,i+size+1);
            String temp2 = s.substring(i+size+1,i+2*size+2);
            if(temp1.equals(temp2)){
                if(!flag){
                    flag = true;
                }
                cnt++;
            }else{
                if(flag){
                result -= (cnt-1)*(size+1);
                    if(cnt >= 100){
                        result += 3;
                    }
                    else if(cnt >= 10){
                        result += 2;
                    }else{
                        result +=1;
                    }
                    flag = false;
                    cnt = 1;
                }
            }
            i += (size);
        }
        if(flag){
            result -= (cnt-1)*(size+1);
            if(cnt >= 100){
                result += 3;
            }else if(cnt >= 10){
                result += 2;
            }else{
                result +=1;
            }
        }
        return result;
    }
    public int solution(String s) {
        int answer = s.length();
        // System.out.println(s.length());
        for(int i = 0 ; i < s.length()/2;i++){
            answer = Math.min(answer,mkShort(s,i));
            // System.out.println(i + " " + mkShort(s,i));
        }
        return answer;
    }
}
