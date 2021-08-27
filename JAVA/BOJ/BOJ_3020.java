package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_3020 {
    static int n, h;
    static int input[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," " );
        Function<String,Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        h = stoi.apply(st.nextToken());
        input = new int[2][h+1];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," " );
            int temp = stoi.apply(st.nextToken());
            input[i % 2][temp]++;
        }
        int cnt[] = new int[h+1];
        int sum = 0;
        for(int i = h ; i >= 1; i--){
            sum += input[0][i];
            cnt[i] = sum;
        }
//        System.out.println(Arrays.toString(cnt));
        sum = 0;
        for(int i = h; i >= 1; i--){
            sum += input[1][i];
            cnt[h-i+1] += sum;
        }
        int result = Integer.MAX_VALUE;
        int resultCnt = 0;
//        System.out.println(Arrays.toString(cnt));
        for(int i = 1 ; i <= h ; i++){
            if(result == cnt[i]){
                resultCnt++;
            }else if(result > cnt[i]){
                result = cnt[i];
                resultCnt=1;
            }
        }
        System.out.println(result+" "+resultCnt);
    }
}
