package self;

public class 소수_만들기 {
	   static int result = 0 ;
	    static void comb(int[] nums,int depth, int start,int size,int sum){
	        if(depth == size){
	     //       System.out.println(sum);
	            boolean flag = true;
	            for(int i = 2 ; i < sum ; i++){
	                if(sum % i == 0 ){
	                    flag = false;
	                    break;
	                }
	            }
	            if(flag) result++;
	        }else{
	            for(int i = start ; i < nums.length; i++){
	                comb(nums , depth +1 , i+1, size, sum + nums[i]);
	            }
	        }
	    }
	    public int solution(int[] nums) {
	        int answer = -1;
	        comb(nums,0, 0,3,0);
	        return result;
	    }
	}