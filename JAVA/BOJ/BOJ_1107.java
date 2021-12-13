package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1107 {
    static boolean broken[];
    static int cal(int target){
        int result = Math.abs(target - 100);
        for(int i = 0; i < 1_000_000 ; i++){
            int length  = check(i);
            if(length > 0){
                result = Math.min(length + Math.abs(target - i),result);
            }
        }
        return result;
    }
    static int check(int num){
        int result = 0;
        if(num == 0){
            if(broken[num]){
                return -1;
            }else{
                return 1;
            }
        }
        while(num > 0){
            if(broken[num%10]){
                return -1;
            }else{
                num /= 10;
                result++;
            }
        }
        return result;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int target = stoi.apply(st.nextToken());
        int m = stoi.apply(br.readLine());
        broken = new boolean[10];
        if(m != 0){
            st = new StringTokenizer(br.readLine()," ");
        }
        for(int i = 0 ; i < m ; i++){
            int temp = stoi.apply(st.nextToken());
            broken[temp] = true;
        }
        System.out.println(cal(target));
    }
}
