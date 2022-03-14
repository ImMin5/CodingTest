//https://programmers.co.kr/learn/courses/30/lessons/12899#

class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        int base = 3;
        String []trans = {"4","1","2"};
        while(n>0){
            int mod = n%3;
            n = (n - 1) / 3;
            answer.append(trans[mod]);
            
        };
       
        return answer.reverse().toString();
    }
}