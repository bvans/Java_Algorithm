package algorithm.array;

import java.util.HashSet;
import java.util.Set;

public class Array {
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
      Set<Integer> set = new HashSet<Integer>();
      for(int i = 0; i <= k && i < nums.length; i++) {
    	  if(!set.add(nums[i])) {
    		  return true;
    	  }
      }
      
      for(int i = k + 1; i < nums.length; i ++) {
    	  set.remove(nums[i - k  - 1]);
    	  if(!set.add(nums[i]))
    		  return true;
      }
      return false;
    }
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,1};
		int k = 0;
		System.out.println(containsNearbyDuplicate(arr, k));
	}
}
