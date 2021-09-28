package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1120 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        String A = st.nextToken();
        String B = st.nextToken();
        int min = 51;
        for(int i = 0 ; i <= B.length() - A.length() ; i++){
            int sum = 0;
            for(int j = 0 ; j < A.length() ; j++){
                if(B.charAt(i+j) != A.charAt(j)){
                    sum++;
                }
            }
            min = Math.min(sum,min);
        }
        System.out.println(min);
    }
}
