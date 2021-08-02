package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2805 {

    static int n;
    static long m;
    static long input[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Function<String, Integer> stoi = Integer::parseInt;
        Function<String, Long> stol = Long::parseLong;
        n = stoi.apply(st.nextToken());
        m = stol.apply(st.nextToken());
        input = new long[n];
        long start = 0;
        long end = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            input[i] = stol.apply(st.nextToken());
            end = Math.max(input[i],end);
        }
        long result = 0;
        while (start <= end) {
            long mid = (start + end) / 2;

            if (cal(mid)){
                result = Math.max(mid,result);

                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        System.out.println(result);
    }

    private static boolean cal(long mid) {
        long sum = 0;
        for (int i = 0 ; i < n ; i++) {
            sum += Math.max(input[i] - mid,0);
        }

        if(sum >= m) return true; // 조건에 맞음
        else return false;
    }
}
