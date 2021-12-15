package BOJ.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1005 {
    static int spendTime[];
    static int count[];
    static int time[];
    static int target;
    static List<Integer> map[];
    static int n, k;
    static int cal(){
//        System.out.println("------");
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1 ; i <= n ; i++){
            if(count[i] == 0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int now = q.poll();
            int nowTime = time[now] + spendTime[now];
//            System.out.println(now+" "+nowTime);
            if(now == target){
                return nowTime;
            }
            for(int i = 0 ; i < map[now].size(); i++){
                int next = map[now].get(i);
                time[next] = Math.max(time[next],nowTime);
                if(--count[next] == 0){
                    q.offer(next);
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int test = stoi.apply(st.nextToken());
        for(int t = 0 ; t < test ; t++){
            st = new StringTokenizer(br.readLine()," ");
            n = stoi.apply(st.nextToken());
            k = stoi.apply(st.nextToken());
            st = new StringTokenizer(br.readLine()," ");

            spendTime = new int[n+1];
            count = new int[n+1];
            time = new int[n+1];
            map = new List[n+1];

            for(int i = 1 ; i <= n ; i++){
                map[i] = new ArrayList<>();
            }

            for(int i = 1 ; i <= n ; i++){
                spendTime[i] = stoi.apply(st.nextToken());
            }
            for(int i = 0 ; i < k; i++){
                st = new StringTokenizer(br.readLine()," ");
                int a = stoi.apply(st.nextToken());
                int b = stoi.apply(st.nextToken());
                map[a].add(b);
                count[b]++;
            }
            st = new StringTokenizer(br.readLine()," ");
            target = stoi.apply(st.nextToken());
            System.out.println(cal());
        }
    }
}
