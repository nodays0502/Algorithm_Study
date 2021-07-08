package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1260 {
    static int n,m,v;
    static List<Integer> map[];
    static boolean visited[];
    static void dfs(int now){
        visited[now] = true;
        System.out.print(now+" ");
        for(int i = 0 ; i < map[now].size(); i++){
            int next = map[now].get(i);
            if(!visited[next]){
                dfs(next);
            }
        }
    }
    static void bfs(){
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[n+1];
        visited[v] = true;
        q.offer(v);
        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now+" ");
            for(int i = 0 ; i < map[now].size(); i++){
                int next = map[now].get(i);
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        map = new ArrayList[n+1];
        for(int i = 0 ; i <= n ; i++){
            map[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }
        for(int i = 0 ; i <= n ; i++){
            Collections.sort(map[i]);
        }
        visited = new boolean[n+1];
        dfs(v);
        System.out.println();
        bfs();
    }
}
