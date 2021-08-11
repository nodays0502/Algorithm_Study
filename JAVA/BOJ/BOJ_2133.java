package BOJ;

import java.util.Scanner;

public class BOJ_2133 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n % 2 == 1) {
            System.out.println(0);
        }else{
            int dp[] = new int[n/2+5];
            dp[0] = 1;
            dp[1] = 3;
//            dp[2] = 11;
            for(int i = 2 ; i < n/2+1 ; i++){
                dp[i] = 3*dp[i-1];
                for(int j = 2 ;  j <= i; j++){
                    dp[i] += 2*dp[i-j];
                }
            }
            System.out.println(dp[n/2]);
        }
    }
}
