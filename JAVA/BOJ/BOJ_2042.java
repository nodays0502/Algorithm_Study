package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2042 {
    static int n,m ;
    static long input[];
    static long tree[];
    static long prefixSum(int i){
        long result = 0;
        while(i > 0){
            result += tree[i];
            i -= (i& -i);
        }
        return result;
    }
    static void update(int i , long dif){
        while(i <= n ){
            tree[i] += dif;
            i += (i & -i);
        }
    }
    static long intervalSum(int start, int end){
        return prefixSum(end) - prefixSum(start-1);
    }
    static Function<String,Integer> stoi = Integer::parseInt;
    static Function<String,Long> stol = Long::parseLong;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = stoi.apply(st.nextToken());
        m = stoi.apply(st.nextToken());
        m += stoi.apply(st.nextToken());
        input = new long[n+1];
        tree = new long[n+1];
        for(int i = 1 ; i <=n  ; i++){
            st = new StringTokenizer(br.readLine()," ");
            input[i] = stol.apply(st.nextToken());
            update(i,input[i]);
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());

            if(a == 1){
                long c = stol.apply(st.nextToken());
                update(b, c-input[b]);
                input[b] = c;
            }else{
                int c = stoi.apply(st.nextToken());
                System.out.println(intervalSum(b,c));
            }
        }
    }
}
