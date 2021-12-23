import java.util.*;
class Solution {
    static int[] result; 
    static Map<String,Integer> index = new HashMap<>();
    static int[] parent;
    static void sell(int nowIndex,int amount){
        int reminder = amount / 10;
        result[nowIndex] += amount - reminder;
        int parentIndex = parent[nowIndex];
        if(parentIndex != -1){
            sell(parentIndex, reminder);
        }
    }
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        result = new int[enroll.length];
        parent = new int[enroll.length];
        Arrays.fill(result,0);
        // System.out.println(index);
        // System.out.println(parent);
        index.put("-",-1);
        for(int i = 0 ; i < enroll.length ; i++){
            index.put(enroll[i],i);
        }
        for(int i = 0 ; i < enroll.length ; i++){
            int parentIndex = index.get(referral[i]);
            int nowIndex= index.get(enroll[i]);
            parent[nowIndex] = parentIndex;
        }
                // System.out.println(index);
        // System.out.println(parent);
        for(int i = 0 ; i< seller.length ; i++){
            int nowIndex = index.get(seller[i]);
            sell(nowIndex, amount[i]*100);
        }
        int[] answer = result;
        return answer;
    }
}
