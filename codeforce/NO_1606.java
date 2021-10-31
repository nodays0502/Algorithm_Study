package Codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class NO_1606 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        Function<String,Long> stol = Long::parseLong;
        int testCnt = stoi.apply(st.nextToken());
        for(int t = 0 ; t < testCnt ; t++){
            st = new StringTokenizer(br.readLine()," ");
            long n = stol.apply(st.nextToken()) - 1;
            long k = stol.apply(st.nextToken());
            long result = 0;
            for(long i = 1 ; i <= k ; i *= 2){
                if(n <= 0) {
                    break;
                }
                n -= i;
                result++;
            }
//            System.out.println(n+" "+result);
            if(n > 0){
                result += n/k + ((n % k != 0)? 1 : 0);
            }
            System.out.println(result);
        }
    }
}
