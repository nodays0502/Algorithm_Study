import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for(int num : scoville){
            p.offer(num);
        }
        while(true){
            int num = p.peek();
            if(num >= K){
                break;
            }else{
                answer++;
                if(p.size() <= 1){
                    answer = -1;
                    break;
                }
                int num1 = p.poll();
                int num2 = p.poll();
                p.offer(num1 + 2*num2);
            }
        }
        return answer;
    }
}
