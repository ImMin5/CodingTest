//https://programmers.co.kr/learn/courses/30/lessons/42862

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int []clothes = new int[n+1];
        Arrays.fill(clothes,1);
        
        for(int i=0; i<reserve.length; i++){
            clothes[reserve[i]]++;
        }
         for(int i=0; i<lost.length; i++){
            clothes[lost[i]]--;
        }
        
        //for(int i=1; i<=n; i++)System.out.print(clothes[i]+ " ");
        for(int i=1; i<=n; i++){
            if(clothes[i] == 2){
                if(clothes[i-1] == 0 && i>1){
                    clothes[i]--;
                    clothes[i-1]++;
                }
                else if(i+1 <=n &&clothes[i+1] == 0 ){
                    clothes[i]--;
                    clothes[i+1]++;
                }
            }
        }
        
        for(int i=1; i<=n; i++){
           if(clothes[i]>0)answer++;
        }
    
   
        return answer;
    }
}