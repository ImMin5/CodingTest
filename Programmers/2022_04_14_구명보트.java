
//https://programmers.co.kr/learn/courses/30/lessons/42885
//참고 https://velog.io/@diddnjs02/%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EA%B5%AC%EB%AA%85%EB%B3%B4%ED%8A%B8

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    static int answer;
    public int solution(int[] people, int limit) {
        answer = 0;
        Arrays.sort(people);
      
        int left = 0;
        int right = people.length -1;
        
        while(left < right){
            int sum = people[left] + people[right];
            if(sum > limit) 
                right--;
            else{
                left++;
                right--;
            }
            answer++;
        }
        if(left == right) answer++;
        
        
       
        return answer;
    }
}
