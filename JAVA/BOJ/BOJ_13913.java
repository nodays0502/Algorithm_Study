package BOJ.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_13913 {
    static int n,m;
    static int prev[];
    static int bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size; s++){
                int now = q.poll();
                if(now == m){
                    return time;
                }
                if(now -1 >= 0 && prev[now-1] == -1){
                    q.offer(now-1);
                    prev[now-1] = now;
                }
                if(now+1 <= 100_000 && prev[now+1] == -1){
                    q.offer(now+1);
                    prev[now+1] = now;
                }
                if(2*now <= 100_000 && prev[2 * now] == -1){
                    q.offer(2*now);
                    prev[2*now] = now;
                }
            }
            time++;
        }
        return -1;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        m = stoi.apply(st.nextToken());
        prev = new int[100_000+1];
        Arrays.fill(prev,-1);
        System.out.println(bfs());
        int num = m;
        List<Integer> result = new ArrayList<>();
        while(true){
            result.add(num);
            if(num == n){
                break;
            }
            num = prev[num];
        }
        Collections.reverse(result);
        for(int number : result){
            System.out.print(number+" ");
        }
    }
}
