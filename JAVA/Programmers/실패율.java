import java.util.*;
class Node{
    int stage;
    double percent;
    public Node(int stage, double percent){
        this.stage = stage;
        this.percent = percent;
    }
}
class Solution {
    
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int num[] = new int[N+2];
        for(int i = 0; i < stages.length; i++){
            num[stages[i]]++;
        }
        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->{
            if(o2.percent != o1.percent)
                if(o2.percent > o1.percent) return 1;
                else return -1;
            else
                return o1.stage - o2.stage;
        });
        int sum = stages.length;
        for(int i = 1; i <= N; i++){
            if(sum != 0)
                q.offer(new Node(i,(double)num[i]/sum));
            else
                q.offer(new Node(i,0));
            sum -= num[i];
        }
        for(int i = 0; i < N; i++){
            System.out.println(q.peek().percent);
            answer[i] = q.poll().stage;
        }
        return answer;
    }
}
