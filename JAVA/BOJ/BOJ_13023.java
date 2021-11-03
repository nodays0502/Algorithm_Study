package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_13023 {
    static int n,m;
    static List<Integer> map[];
    static boolean visited[];
    static boolean flag = false;
    static void dfs(int depth, int now){
        visited[now] = true;
//        System.out.println(depth +" "+now);
        if(flag){
            return;
        }
        if(depth == 4){
            flag = true;
        }
        else{
            boolean flag = false;
            for(int i = 0 ; i < map[now].size() ; i++){
                int next = map[now].get(i);
//                System.out.println(next);
                if(!visited[next]){
                   dfs(depth+1, next);
                }
            }
        }
        visited[now] = false;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        m = stoi.apply(st.nextToken());
        visited = new boolean[n];
//        map = new boolean[n][n];
        map = new List[n+1];
        for(int i = 0 ; i < n ; i ++){
            map[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
//            map[a][b] = true;
//            map[b][a] = true;
            map[a].add(b);
            map[b].add(a);
        }
        boolean result = false;
        for(int i = 0 ; i < n ; i++){
            dfs(0,i);
            if(flag){
                result = true;
                break;
            }
        }
        if(result){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}
