package Codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO_1328 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int mul = 0;
            if(a % b == 0){
                mul = a/b;
                System.out.println(mul * b - a);
            }else{
                mul = a/b + 1;
                System.out.println(mul * b - a);
            }
        }
    }
}
