package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class BOJ_2668 {
    static int n;
    static int input[];
    static List<Integer>list;
    static boolean choice[];
    static void dfs(int now ){
        int next = input[now];
        boolean flag = false;
//        System.out.println(now);
//        System.out.println(list);
        for(int elem : list){
            if(elem == now){
                flag = true;
            }
            if(flag){
                choice[elem] = true;
            }
        }
        if(flag || choice[now]){
            return;
        }
        list.add(now);

        dfs(next);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer>stoi = Integer::parseInt;
        n = stoi.apply(br.readLine());
        input = new int[n+1];
        choice = new boolean[n+1];
        for(int i = 1 ;i <= n ; i++){
            input[i] = stoi.apply(br.readLine());
        }
        for(int i = 1 ; i <= n ; i++){
            list = new ArrayList<>();
            if(!choice[i])
                dfs(i);
        }
        int result = 0;
        for(int i = 1 ; i <= n ; i++){
            if(choice[i]){
                result++;
            }
        }
        System.out.println(result);
        for(int i = 0; i <= n ; i++){
            if(choice[i])
            System.out.println(i);
        }
    }
}
