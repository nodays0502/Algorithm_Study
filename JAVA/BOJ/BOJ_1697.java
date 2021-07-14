package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697 {
    static int bfs(int n , int k){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[100001];
        q.offer(n);
        visited[n] = true;
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size; i++){
                int now = q.poll();
                if(now == k) return time;
                if(now-1 >=0 &&!visited[now-1]){
                    visited[now-1] = true;
                    q.offer(now-1);
                }
                if(now+1 <= 100000 && !visited[now+1]){
                    visited[now+1] = true;
                    q.offer(now+1);
                }
                if(2*now <= 100000 && !visited[2*now]){
                    visited[2*now] = true;
                    q.offer(2*now);
                }
            }
            time++;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(bfs(n,k));
    }
}
