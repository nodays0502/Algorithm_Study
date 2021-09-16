package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_3665 {
    static int n, m;
    static boolean[][] map;
    static int degree[];
    static List<Integer>result = new ArrayList<>();
    static void bfs(){
        Queue<Integer> q= new LinkedList<>();
        for(int i = 1 ; i<=n ; i++){
            if(degree[i] == 0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            boolean flag = false;
            if(size >= 2){
                flag = true;
            }
            for(int t = 0 ; t < size; t++){
                int now = q.poll();
                if(flag){
                    result.add(0);
                }else{
                    result.add(now);
                }
                for(int i = 1 ; i <= n ; i++){
                    if(map[now][i]){
                        if(--degree[i] == 0){
                            q.offer(i);
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int T = stoi.apply(st.nextToken());
        for(int t = 0 ; t < T ; t++){
            st= new StringTokenizer(br.readLine()," ");
            n = stoi.apply(st.nextToken());
            map = new boolean[n+1][n+1];
            degree = new int[n+1];
            result = new ArrayList<>();
            List<Integer>prev = new ArrayList<>();
            st= new StringTokenizer(br.readLine()," ");
            for(int i = 0 ; i < n ; i++){
                int now = stoi.apply(st.nextToken());
                if(!prev.isEmpty()){
                    for(int j = 0 ; j < prev.size() ; j++){
                        int pre = prev.get(j);
                        map[pre][now] = true;
                        degree[now]++;
                    }

                }
                prev.add(now);
            }
            st= new StringTokenizer(br.readLine()," ");
            m = stoi.apply(st.nextToken());
            for(int i = 0 ; i < m ; i++){
                st= new StringTokenizer(br.readLine()," ");
                int a = stoi.apply(st.nextToken());
                int b = stoi.apply(st.nextToken());
                if( map[b][a] ){
                    map[b][a] = false;
                    degree[a]--;
                    degree[b]++;
                    map[a][b]= true;
                }else{
                    map[b][a] = true;
                    degree[b]--;
                    degree[a]++;
                    map[a][b]= false;
                }

            }
            bfs();
            boolean flag = true;
            for(int i = 0 ; i <= n ; i++){
                if(degree[i]!= 0){
                    flag = false;
                }
            }
            if(flag){
                for(int i = 0 ; i < n ; i++){
                    if (result.get(i) != 0)
                        System.out.print(result.get(i) + " ");
                    else {
                        System.out.print("? ");
                    }
                }
                System.out.println();
            }else{
                System.out.println("IMPOSSIBLE");
            }
        }

    }
}
