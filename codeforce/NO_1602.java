package Codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NO_1602 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine());
        for(int t = 0 ; t < testCnt ; t++){
            String command = br.readLine();
            StringBuilder sb = new StringBuilder(command);
            int index = 0;
            char lowChar = sb.charAt(0);
            for(int i = 1 ; i < sb.length() ; i++){
                char now = sb.charAt(i);
                if(now < lowChar){
                    index = i;
                    lowChar = now;
                }
            }
            sb.deleteCharAt(index);
            System.out.println(lowChar +" "+sb.toString() ) ;

        }
    }
}
