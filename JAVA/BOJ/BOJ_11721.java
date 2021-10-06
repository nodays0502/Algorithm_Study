package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_11721 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = br.readLine();
        for(int i = 0 ; i < command.length() ; i+=10){
            String temp = command.substring(i,Math.min(i+10,command.length()));
            System.out.println(temp);
        }
    }
}
