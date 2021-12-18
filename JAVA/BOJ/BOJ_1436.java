package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1436 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num = 666;
        int count = 0;
        while(true){
            if(Integer.toString(num).contains("666")){
                if(++count == n){
                    break;
                }
            }
            num++;
        }
        System.out.println(num);
    }
}
