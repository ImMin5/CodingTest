//https://programmers.co.kr/learn/courses/30/lessons/12973?language=java#
// 효율성 통과 못한 풀이 
class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        for(int i=0;  i<s.length()-1;){
            if(s.charAt(i) == s.charAt(i+1)){
                s = s.substring(0,i) + s.substring(i+2,s.length());
                i =0;
            }
            else{
                i++;
            }
        }
        
        if(s.length() == 0) answer =1;
        

        return answer;
    }
}

//효율성 통과 
import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        
        Stack<Character> stack = new Stack<>();
        
        int i=0;
        for(i=0;  i<s.length();i++){
            if(stack.isEmpty() == true) stack.push(s.charAt(i));
            else{
                if(stack.peek() == s.charAt(i)){
                    stack.pop();
                }
                else
                    stack.push(s.charAt(i));
            }
        }
          
        
        if(stack.isEmpty() == true ) answer =1;
        

        return answer;
    }
}