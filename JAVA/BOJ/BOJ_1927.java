package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1927 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int num = stoi.apply(st.nextToken());
            if(num != 0){
                pq.offer(num);
            }else{
                if(pq.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(pq.poll());
                }
            }
        }
    }
}
