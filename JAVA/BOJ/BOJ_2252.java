package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2252 {
    static List<Integer> result = new ArrayList<>();
    static void bfs(int n,int m , int[] degree, List<Integer>list[]){
        Queue<Integer> q = new LinkedList<>();
//        System.out.println(Arrays.toString(degree));
        for(int i = 1 ; i <= n ; i++){
            if(degree[i] == 0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int now = q.poll();
//            System.out.println(now);
            result.add(now);
            for(int i = 0 ; i < list[now].size();i++){
                int next = list[now].get(i);
                if(--degree[next] == 0){
                    q.offer(next);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int n , m;
        Function<String,Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        m = stoi.apply(st.nextToken());
        int degree[] = new int[n+1];
        List<Integer> list []= new List[n+1];
        for(int i = 0 ; i < n+1 ; i++){
            degree[i]= 0;
            list[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < m ; i++){
            st= new StringTokenizer(br.readLine()," ");
            int a= stoi.apply(st.nextToken());
            int b= stoi.apply(st.nextToken());
            list[a].add(b);
            degree[b]++;
        }
        bfs(n,m,degree,list);
        for(int i = 0 ; i < result.size() ; i++){
            System.out.print(result.get(i)+" ");
        }
    }

}
