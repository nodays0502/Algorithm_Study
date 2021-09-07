package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1316 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int result = 0;
        for(int t = 0 ; t < T ; t++){
            String command = br.readLine();
            if(check(command)){
                result++;
            }
        }
        System.out.println(result);
    }

    private static boolean check(String command) {
        char[] chars = command.toCharArray();
        boolean [] alpha = new boolean[26];
        for(int i = 0 ; i < chars.length ; i++){
            if(i != 0 && chars[i-1] == chars[i]) continue;
            int now = chars[i]-'a';
            if(alpha[now]){
                return false;
            }else{
                alpha[now] = true;
            }
        }
        return true;
    }
}
