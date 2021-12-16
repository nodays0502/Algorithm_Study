package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1931 {
    private static class Node{
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        Queue<Node> q = new PriorityQueue<>((o1,o2)->{
            if(o1.end == o2.end){
                return o1.start - o2.start;
            }else{
                return o1.end - o2.end;
            }
        });
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            q.offer(new Node(a,b));
        }
        int result = 0;
        int endTime = -1;
        while(!q.isEmpty()){
            Node now = q.poll();
            int start = now.start;
            int end = now.end;
            if(start >= endTime){
                endTime = end;
                result++;
            }
        }
        System.out.println(result);
    }
}
