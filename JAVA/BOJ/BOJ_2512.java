package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2512 {
    static int n,m;
    static int input[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        st= new StringTokenizer(br.readLine()," ");
        input = new int[n];
        int sum = 0 ;
        int max = 0 ;
        for(int i = 0 ; i < n ; i++){
            input[i] = stoi.apply(st.nextToken());
            sum += input[i];
            max = Math.max(input[i],max);
        }
        st= new StringTokenizer(br.readLine()," ");
        m = stoi.apply(st.nextToken());
        if(sum <= m){
            System.out.println(max);
            return ;
        }
        int result = 0;
        int start = 0 ;
        int end = 1000000000;
        while(start <= end){
            int mid = (start + end)/2;
            if(cal(mid)){
                result = Math.max(result,mid);
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        System.out.println(result);
    }

    private static boolean cal(int mid) {
        int sum = 0 ;
        for(int i = 0 ; i < n ; i++){
            sum += Math.min(input[i],mid);
        }
        if(sum <= m)return true;
        else return false;
    }
}
