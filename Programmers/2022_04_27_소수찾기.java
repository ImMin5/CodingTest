//https://programmers.co.kr/learn/courses/30/lessons/42839

import java.util.ArrayList;


class Solution {
    static int answer;
    static boolean []used;
    static ArrayList<Integer> pnum;
    public int solution(String numbers) {
   String[] str = new String[numbers.length()];
		
		answer = 0;
		pnum = new ArrayList<Integer>();
		used = new boolean[numbers.length()];
		
		for(int i=0; i<numbers.length(); i++) str[i] = Character.toString(numbers.charAt(i));
		for(int i=0; i<str.length; i++) {
	            used[i] = true;
	            dfs(str,str[i],0);
	            used[i] = false;
	        }
        for(int i=0; i<pnum.size(); i++)
            if(isPrime(pnum.get(i))) answer++;
    
	        
        return answer;
    }
    
    static public void dfs(String []str, String num, int depth) {
	    	//System.out.println("num : " + num);
	    	if(depth > str.length) return;
	    	if(numCheck(Integer.parseInt(num)))pnum.add(Integer.parseInt(num));
	        for(int i=0; i<str.length; i++) {
	            if(used[i] == false){
	                used[i] = true;
	                dfs(str,num+str[i],depth+1);
	                used[i] = false;
	            }
	        }
	    }
    static public boolean numCheck(int num){
        for(int i=0; i<pnum.size(); i++){
            if(pnum.get(i) == num) return false;
        }
        return true;
    }
		
    static public boolean isPrime(int num) {
			if(num <=1) return false;
        	if( num == 2 || num == 3) return true;
			for(int i=(int) Math.sqrt(num); i>1; i--) {
				if(num%i==0) return false;
			}
			return true;
	}
}