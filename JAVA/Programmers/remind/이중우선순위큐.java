import java.util.*;
import java.util.function.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        int count = 0;
        Function<String,Integer> stoi = Integer::parseInt;
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((o1,o2)->{
            return o2 - o1;
        });
        PriorityQueue<Integer> minQ = new PriorityQueue<>((o1,o2)->{
            return o1 - o2;
        });
        for(String operation : operations){
            String[] temp = operation.split(" ");
            int num = stoi.apply(temp[1]);
            if("I".equals(temp[0])){
                maxQ.offer(num);
                minQ.offer(num);
                count++;
            }else{
                if(count > 0){
                    count--;
                    if(num == 1){
                        System.out.println("max:"+maxQ.poll());
                    }else{
                        System.out.println("min:"+minQ.poll());
                    }
                }
                if(count == 0){
                    maxQ = new PriorityQueue<>((o1,o2)->{
                        return o2 - o1;
                    });
                    minQ = new PriorityQueue<>((o1,o2)->{
                        return o1 - o2;
                    });
                }
            }
        }
        if(count == 0){
            answer = new int[]{0,0};
        }else{
            answer = new int[]{maxQ.poll(),minQ.poll()};
        }
        return answer;
    }
}
