package Codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO_1343 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int now = Integer.parseInt(st.nextToken());
            int div = now /2;
            if(div % 2 == 1){
                System.out.println("NO");
            }else{
                System.out.println("YES");
                int sumEven = 0;
                int sumOdd = 0;
                for(int j = 1 ; j <= div ; j++){
                    System.out.print(2*j+" ");
                    sumEven += 2*j;
                }
                for(int j = 0 ; j < div - 1 ; j++){
                    System.out.print((1+2*j)+" ");
                    sumOdd += 1+2*j;
                }
                System.out.println( sumEven - sumOdd);
            }
        }
    }
}
