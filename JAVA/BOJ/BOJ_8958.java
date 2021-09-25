package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_8958 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int t = 0 ; t < n ; t++){
            String command = br.readLine();
            int num =0;
            int sum = 0;
            for(int i = 0 ; i < command.length() ; i++){
                char ch = command.charAt(i);
                if(ch == 'O'){
                    sum += ++num;
                }else{
                    num = 0;
                }
            }
            System.out.println(sum);
        }

    }
}
