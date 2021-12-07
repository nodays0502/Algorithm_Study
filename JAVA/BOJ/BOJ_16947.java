package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_16947 {
    static int n;
    static int count[];
    static int result[];
    static List<Integer> map[];
    static boolean visited[];
    static void cal(){
        visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1 ; i <= n ; i++){
            if(count[i] == 1){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int now = q.poll();
            visited[now] = true;
            for(int i = 0 ; i < map[now].size() ; i++){
                int next = map[now].get(i);
                if(!visited[next]){
                    if(--count[next] == 1){
                        q.offer(next);
                    }
                }
            }
        }
        visited = new boolean[n+1];
        for(int i = 1 ; i <= n ; i++){
            if(count[i] > 1){
                result[i] = 0;
                dfs(1, i);
            }
        }
    }
    static void dfs(int depth,int now){
        visited[now] = true;
        for(int i = 0 ; i < map[now].size() ; i++){
            int next = map[now].get(i);
            if(count[next] <= 1 && !visited[next]){
                result[next] = depth;
                dfs(depth+1,next);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        map = new List[n+1];
        for(int i = 0 ; i <= n ; i++){
            map[i] = new ArrayList<>();
        }
        count = new int[n+1];
        result = new int[n+1];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            map[a].add(b);
            map[b].add(a);
            count[a]++;
            count[b]++;
        }
        cal();
        for(int i = 1 ; i <= n ; i++){
            System.out.print(result[i]+" ");
        }
    }
}
