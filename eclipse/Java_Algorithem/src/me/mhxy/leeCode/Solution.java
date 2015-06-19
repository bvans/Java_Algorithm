package me.mhxy.leeCode;

public class Solution {
    public static boolean isPalindrome(int x) {
    	if (x < 0) {
    		return false;
    	}
    	
        if (x < 10)
            return true;
        
        int r = 0;
        int tmp = x;
        while ( tmp > 0) {
        	r = tmp % 10 + r * 10;
        	tmp = tmp / 10;
        }
        
        if (r == x) {
        	return true;
        } else {
        	return false;
        }
    }
    
    public static void main(String[] args) {
		System.out.println(isPalindrome(1221));
	}
}