package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9012 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n  ; i++){
            String command = br.readLine();
            cal(command);
        }
    }
    private static void cal(String command) {
        boolean flag = true;
        int cnt = 0 ;
        for(int i = 0 ; i < command.length(); i++){
            char now = command.charAt(i);
            if(now == '('){
                cnt++;
            }else { // ')'
                if(cnt <= 0){
                    flag = false;
                }else{
                    cnt--;
                }
            }
        }
        if(cnt != 0){
            flag = false;
        }
        if(flag){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
