package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1967 {
    static class Node {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
    static int n ;
    static List<Node> map[];
    static boolean visited[];
    static int cal(int start){
        visited = new boolean[n+1];
        visited[start] = true;
        if(map[start].size()<=1){
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < map[start].size() ; i++){
            Node next = map[start].get(i);
            list.add( dfs(next.end) + next.weight);
        }
        Collections.sort(list,(o1, o2) -> {
            return o2 - o1;
        });
        return list.get(0) + list.get(1);
    }
    static int dfs(int now){
        visited[now] = true;
        int result = 0;
        for(int i = 0 ; i < map[now].size() ; i++){
            Node next = map[now].get(i);
            if(!visited[next.end]){
                result = Math.max(dfs(next.end) + next.weight,result);
            }
        }
        return result;
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
        for(int i = 0 ; i < n-1 ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            int c = stoi.apply(st.nextToken());
            map[a].add(new Node(b,c));
            map[b].add(new Node(a,c));
        }
        int result = 0 ;
        for(int i = 1; i <= n ; i++){
//            System.out.println(i);
            result = Math.max(result,cal(i));
        }
        System.out.println(result);
    }

}
