import java.util.*;
class Solution {
    static String cal(String s){
        if(s.length() == 0) return s;
        int cnt = 0;
        int index = 0;
        boolean flag = true;
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length(); i++){
            // System.out.println(cnt);
            if(s.charAt(i) == '(') {
                cnt++;
                stack.push(s.charAt(i));
            }else{
                cnt--;
                if(stack.isEmpty()){
                    flag = false;
                }else{
                    stack.pop();
                }
            }
            if(cnt == 0){
                index = i;
                break;
            }
        }
        String u = s.substring(0,index+1);
        String v = s.substring(index+1,s.length());
        System.out.println(flag);
        System.out.println(u);
        System.out.println(v);
        if(flag){
            return u + cal(v);
        }else{
            StringBuilder sb = new StringBuilder();
            for(int i = 1 ; i < u.length()-1; i++){
                if(u.charAt(i) == '('){
                    sb.append(')');
                }else{
                    sb.append('(');
                }
            }

            return '('+cal(v) + ')' + sb.toString();
        }
        
    }
    public String solution(String p) {
        String answer = "";
        answer = cal(p);
        return answer;
    }
}
