package BOJ;

import java.util.Scanner;

public class BOJ_1065 {
    static boolean cal(int num){
        String now = Integer.toString(num);
        if(now.length() <= 2) return true;
        for(int i = 0 ; i < now.length() - 2; i++){
            if(now.charAt(i)-now.charAt(i+1) != now.charAt(i+1)-now.charAt(i+2))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        for(int i = 1 ; i <= n ; i++){
            if(cal(i))result++;
        }
        System.out.println(result);
    }
}
