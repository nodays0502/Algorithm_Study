package BOJ.MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_10423 {
    private static class Node{
        int start;
        int end;
        int weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
    static int findSet(int[] parent, int index){
        if(parent[index] == index) return index;
        else{
            return parent[index] = findSet(parent,parent[index]);
        }
    }
    static boolean union(int[] parent, int a, int b){
        int parentA = findSet(parent,a);
        int parentB = findSet(parent,b);
        if(parentA == parentB){
            return false;
        }else{
            parent[parentA] = parentB;
            return true;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        int[] parent = new int[n + 1];
        for(int i = 1 ; i <= n ; i++){
            parent[i] = i;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{
            return o1.weight - o2.weight;
        });
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < k ; i++){
            int number = stoi.apply(st.nextToken());
            parent[number] = 0;
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int start = stoi.apply(st.nextToken());
            int end = stoi.apply(st.nextToken());
            int weight = stoi.apply(st.nextToken());
            pq.offer(new Node(start,end,weight));
        }


        int result = 0;
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(union(parent,now.start,now.end)){
//                System.out.println(now.start+" "+now.end+" "+now.weight);
                result += now.weight;
            }
        }
        System.out.println(result);
    }

}
