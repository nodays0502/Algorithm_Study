package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2531 {

    static int n, d, k, c;
    static int input[];
    static int count[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Function<String, Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        d = stoi.apply(st.nextToken());
        k = stoi.apply(st.nextToken());
        c = stoi.apply(st.nextToken());
        input = new int[n + k];
        count = new int[d + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            input[i] = stoi.apply(st.nextToken());
        }
        int result = 1;
        int sum = 1;

        for(int i = 0 ; i < k ; i++){
            input[n  + i] = input[i];
        }
        for (int i = 0 ; i < n+k ; i++) {
            if(input[i] != c && count[input[i]] == 0){
                sum++;
            }
            count[input[i]]++;
            if(i-k >= 0){
                count[input[i-k]]--;
                if(input[i-k] != c && count[input[i-k]] == 0){
                    sum--;
                }
            }
//            System.out.println(input[i]+" "+sum);
//            System.out.println(Arrays.toString(count));
            result = Math.max(result,sum);
        }
        System.out.println(result);
    }
}
