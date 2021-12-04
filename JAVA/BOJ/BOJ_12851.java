package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_12851 {
    static int n,m;
    static final int LIMIT = 100_000;
    static boolean visited[] = new boolean[2*LIMIT+1];
    static void cal(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        int time = 0;
        int cnt =0;
        boolean flag = false;
        while(!q.isEmpty()){
            int size = q.size();
            for(int t = 0 ; t < size ; t++){
                int now = q.poll();
                visited[now] = true;
                if(now == m){
                    flag = true;
                    cnt++;
                }
                if(now -1 >=0 && !visited[now-1]){
                    q.offer(now - 1);
                }
                if(now + 1 <= LIMIT && !visited[now+1]){
                    q.offer(now + 1);
                }
                if(now < LIMIT && !visited[2 * now]){
                    q.offer(2 * now);
                }
            }
            if(flag){
                break;
            }
            time++;
        }
        System.out.println(time);
        System.out.println(cnt);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        n = stoi.apply(st.nextToken());
        m = stoi.apply(st.nextToken());
        cal();
    }
}
