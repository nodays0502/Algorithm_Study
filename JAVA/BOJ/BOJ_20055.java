package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_20055 {
    static int n,k;
    static int input[];
    static boolean robot[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        k = stoi.apply(st.nextToken());
        input = new int[2*n];
        robot = new boolean[2*n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < 2*n ; i++){
            input[i] = stoi.apply(st.nextToken());
        }
        int upIndex = 0;
        int downIndex = n-1;
        int result = 0;
        while(true){
//            System.out.println(Arrays.toString(input));
//            System.out.println(Arrays.toString(robot));
//            System.out.println(upIndex);
//            System.out.println(downIndex);
            result++;
            upIndex--;
            downIndex--;
            if(upIndex < 0){
                upIndex = 2 * n-1;
            }
            if(downIndex < 0){
                downIndex = 2 * n-1;
            } // 1단계
            int index = downIndex;
            while(index != upIndex){
                int nextIndex = index + 1;
                if(nextIndex >= 2*n){
                    nextIndex = 0;
                }
                if(robot[index]){
                    if(index == downIndex){
                        robot[index] =false;
                    }else if(robot[index] && !robot[nextIndex] && input[nextIndex] >0){
                        robot[index] = false;
                        robot[nextIndex] = true;
                        input[nextIndex]--;
                        if(nextIndex == downIndex){
                            robot[nextIndex] = false;
                        }
                    }
                }
                index--;
                if(index < 0){
                    index = 2*n - 1;
                }
            } // 2단계
            if(input[upIndex] > 0){
                input[upIndex]--;
                robot[upIndex] = true;
            }// 3단계
            if(check()){
                break;
            }
        }
        System.out.println(result);
    }
    static boolean check(){
        int cnt = 0 ;
        for(int i = 0 ; i < 2 * n ; i++){
            if(input[i] <= 0 ){
                cnt++;
            }
        }
        return cnt >= k? true : false;
    }
}
