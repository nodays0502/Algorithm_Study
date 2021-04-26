

class Solution {
	static int m,n;
	static boolean check(int[][] key, int[][] lock) {
		for(int i = 0 ; i < m +  n - 1 ; i++) {
			for(int j = 0 ; j <  n + m - 1 ; j++) {
				if(matching(key, lock,i,j))
					return true;				
			}
		}
		return false;
	}
	
	static boolean matching(int[][] key, int[][] lock, int y ,int x) {
		for(int i = 0 ; i < n; i++) {
			for(int j  = 0 ; j < n ; j++) {
				if(key[y+i][x+j] == lock[i][j]) return false;
			}
		}
		return true;
	}
	static void rotate(int[][] arr) {
		int length = arr.length;
	    int[][] temp = new int[length][length];
	    for (int i = 0; i < temp.length; i++) {
	        for (int j = 0; j < temp[i].length; j++) {
	        	temp[i][j] = arr[length - 1 - j][i];
	        }
	    }

	    for (int i = 0; i < temp.length; i++) {
	        for (int j = 0; j < temp[i].length; j++) {
	        	arr[i][j] = temp[i][j];
	        }
	    }
	}
	static void print(int[][]arr) {
		for(int i = 0 ; i < arr.length; i++) {
			for(int j = 0 ; j < arr.length ; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
    public boolean solution(int[][] key, int[][] lock) {
    	m = key.length;
    	n = lock.length;
    	boolean answer = false;
    	int[][] newkey = new int[m + 2 * n - 2][m + 2 * n - 2];
    	
    	for(int i = 0 ; i < m ; i++) {
    		for(int j = 0 ; j < m ;j++) {
    			newkey[n-1+i][n-1+j] = key[i][j];
    		}
    	}
    	
    	print(lock);
    	for(int i = 0 ; i < 4; i++) {
    		print(newkey);
    		System.out.println();
    		if(check(newkey,lock)) {
    			answer = true;
    			break;
    		}
    		rotate(newkey);
    	}
        return answer;
    }
}
