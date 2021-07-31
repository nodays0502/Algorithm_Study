package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003 {
    static int n,m;
    static int input[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        input = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < n ; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0 ;
        int si = 0 ;
        int ei = 0 ;
        int sum = 0;
        while(true){
//            System.out.println("sum:"+sum);
            if(sum > m){
                sum -= input[si++];
            }else if(sum == m){
                result++;
                sum -= input[si++];
            }else{
                if(ei == n) break;
                sum += input[ei++];
            }
        }
        System.out.println(result);
    }
}
