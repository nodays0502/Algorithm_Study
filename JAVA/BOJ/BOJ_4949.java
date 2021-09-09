package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String command = br.readLine();
            if(".".equals(command)){
                break;
            }
            Stack<Character> stack = new Stack();
            boolean result = true;
            for(int i = 0 ; i < command.length(); i++){
                char now  = command.charAt(i);
                if(now == '(' || now == '['){
                    stack.push(now);
                }else if(now == ')' || now == ']'){
                    char pop = '.';
                    if(!stack.isEmpty()){
                        pop = stack.pop();
                    }else{
                        result = false;
                        break;
                    }
                    if(!(now == ')' && pop == '(') && !(now == ']' && pop == '[')){
                        result = false;
                        break;
                    }
                }
            }
            if(!stack.isEmpty()){
                result= false;
            }
            if(!result){
                System.out.println("no");
            }else{
                System.out.println("yes");
            }
        }

    }
}
