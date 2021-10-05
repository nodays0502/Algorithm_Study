package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1543 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int result = 0 ;
        for(int i = 0 ; i < a.length() - b.length() + 1; i ++){
            String temp = a.substring(i, i + b.length());
//            System.out.println(temp);
            if(temp.equals(b)){
                result++;
                i += (b.length()-1);
            }

        }
        System.out.println(result);
    }
}
