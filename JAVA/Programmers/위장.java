import java.util.*;
class Solution {
    static int index = 0;
    static Map<String,Integer> map = new HashMap<>();
    static List<Integer> list = new LinkedList<>();
    public int solution(String[][] clothes) {
        int answer = 1;
        for(String[] cloth : clothes){
            if(!map.containsKey(cloth[1])){
                map.put(cloth[1],index++);
                list.add(2);
            }else{
                int clothIndex = map.get(cloth[1]);
                list.set(clothIndex,list.get(clothIndex)+1);
            }
        }
        for(int num : list){
            // System.out.println(num);
            answer *= num;
        }
        answer--;
        return answer;
    }
}
