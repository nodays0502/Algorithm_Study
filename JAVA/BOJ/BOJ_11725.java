package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_11725 {
    static int n;
    static List<Integer> map[];
    static int result[];
    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        boolean visited[] = new boolean[n+1];
        visited[1] = true;
        while(!q.isEmpty()){
            int now = q.poll();
//            System.out.println(now);
            for(int i = 0 ; i < map[now].size(); i++){
                int next = map[now].get(i);
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                    result[next] = now;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String, Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        map = new List[n+1];
        result = new int[n+1];
        for(int i = 0 ; i <= n ; i++){
            map[i] = new ArrayList<>();
        }
        for(int i = 1 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }
        bfs();
        for(int i = 2; i <=n;  i++ ){
            System.out.println(result[i]);
        }
    }
}
