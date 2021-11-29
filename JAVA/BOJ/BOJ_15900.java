package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_15900 {
    static List<Integer> map[];
    static boolean visited[];
    static int result = 0;
    static void dfs(int now,int cnt){
        visited[now] = true;
        for(int i = 0; i < map[now].size(); i++){
            int next = map[now].get(i);
            if(!visited[next]){
                dfs(next,cnt+1);
            }
        }
        if(map[now].size() == 1){
//            System.out.println("asd");
            result += cnt;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        map = new List[n+1];
        visited = new boolean[n+1];
        for(int i= 0  ; i <= n ;i++){
            map[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < n-1 ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }
        dfs(1,0);
//        System.out.println(result);
        if(result % 2 != 0){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
