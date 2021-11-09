package Codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO_749_A {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = n / 2;
        System.out.println(k);
        for(int i = 0 ; i < k ; i++){
            if(i == k -1 && n%2 != 0){
                System.out.print(3);
            }else {
                System.out.print(2+" ");
            }
        }
    }
}
