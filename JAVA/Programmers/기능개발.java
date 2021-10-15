import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int size = progresses.length;
        int day[] = new int[size];
        for(int i = 0 ; i < size ; i++){
            int totalDay = 100 - progresses[i];
            int requireDay = totalDay / speeds[i] + (totalDay % speeds[i] == 0 ? 0:1);
            day[i] = requireDay;
            System.out.println(day[i]);
        }
        List<Integer> list = new LinkedList<>();
        int index = 1;
        int nowDay = day[0];
        int cnt = 1;
        while(index < size){
            // System.out.println(index);
            if(day[index] <= nowDay){
                cnt++;
            }else{
                list.add(cnt);
                cnt = 1;
                nowDay = day[index];
            }
            index++;
        }
        list.add(cnt);
        answer = new int[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
