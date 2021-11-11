package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1654 {
    static int n;
    static int k;
    static long input[];
    static long binarySearch(long min , long max){
        long start = min;
        long end = max;
        long result = 0;
        while(start <= end ){
            long mid = (start + end)/2;
            if(mid == 0){
                start = mid +1;
                continue;
            }
//            System.out.println(mid);
            long temp = 0;
            for(long num : input){
                temp += num / mid;
            }
            if(temp >= k){
                result = Math.max(result,mid);
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }
        return result;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        Function<String,Long> stol = Long::parseLong;
        n = stoi.apply(st.nextToken());
        k = stoi.apply(st.nextToken());
        long max = 0;
        input = new long[n];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            input[i] = stol.apply(st.nextToken());
            max = Math.max(max,input[i]);
        }
        System.out.println(binarySearch(0,max));
    }
}
