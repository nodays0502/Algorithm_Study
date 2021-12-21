package BOJ.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1167 {
    static int count[];
    private static class Node{
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
    static boolean visited[];
    static int maxNode;
    static int maxDistance;
    private static void dfs(int now,int distance){
        visited[now] = true;
        int result = 0;
        if(distance > maxDistance){
            maxDistance = distance;
            maxNode = now;
        }
        for(Node next : map[now]){
            if(!visited[next.end]){
                dfs(next.end,distance + next.weight);
            }
        }

    }
    static int n;
//    static Map<String,Integer> dp;
    static List<Node> map[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        map = new List[n+1];
        count = new int[n+1];
//        dp = new HashMap<>();
        for(int i = 0 ; i <= n ; i++){
            map[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int start = stoi.apply(st.nextToken());
            int end = stoi.apply(st.nextToken());
            while(end != -1){
                count[end]++;
                int weight = stoi.apply(st.nextToken());
                map[start].add(new Node(end,weight));
                end = stoi.apply(st.nextToken());
            }
        }
        int result = 0;
        visited = new boolean[n+1];
        maxNode = 0;
        maxDistance = 0;
        dfs(1,0);

        visited = new boolean[n+1];
        maxDistance = 0;
        dfs(maxNode,0);
        System.out.println(maxDistance);
    }
}
