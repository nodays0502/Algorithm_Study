import java.util.*;
class Solution {
    static Map<String,Integer>[] set;
    static void pick(StringBuilder sb,char[] orderChar,int number,int index,int depth,int start){
        if(depth == number){
            set[index].merge(sb.toString(), 1, (v,nv)-> v+1);
        }
        for(int i = start ; i < orderChar.length ; i++){
            sb.append(orderChar[i]);
            pick(sb,orderChar,number,index,depth + 1, i+1);
            sb.deleteCharAt(depth); 
        }
    }
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        set = new HashMap[course.length];
        for(int i = 0 ; i < course.length ; i++){
            set[i] = new HashMap<>();
        }
        for(String order : orders){
            char[] orderChar = order.toCharArray();
            Arrays.sort(orderChar);
            for(int i = 0 ; i < course.length ; i++){
                StringBuilder sb = new StringBuilder();
                pick(sb,orderChar,course[i],i,0,0);
            }
        }
        List<String> result = new ArrayList<>();
        for(int i = 0 ; i < set.length ; i++){
            int max = 0;
            for(Map.Entry<String,Integer> elem : set[i].entrySet() ){
                max = Math.max(max,elem.getValue());
            }
            // System.out.println("max:"+i+" "+max);
            if(max >= 2){
                for(Map.Entry<String,Integer> elem : set[i].entrySet() ){
                    if(elem.getValue() == max){
                        
                        result.add(elem.getKey());
                    }
                }
            }
        }
        answer = new String[result.size()];
        Collections.sort(result);
        for(int i = 0 ; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}
