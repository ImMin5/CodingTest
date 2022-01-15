//https://programmers.co.kr/learn/courses/30/lessons/60058#

class Solution {
    public String solution(String p) {
        String answer = "";
        answer = sol(p);
        return answer;
    }
    
    static String sol(String p){
        String u,v;
        int idx = 0;
        int count = 0;
        
        if(check(p) == true) return p;
        
        for(idx = 0; idx<p.length(); idx++){
            if(p.charAt(idx) == '(') count++;
            else if(p.charAt(idx) == ')') count--; 
            if(count == 0) break;
        }
          
        u = p.substring(0,idx+1);
        v = p.substring(idx+1);
        
        if(check(u) == true) return u.concat(sol(v));
        else{
            String temp = "("; //4-1
            temp = temp.concat(sol(v)+")");// 4-2,4-3
            //4-4
            u = u.substring(1,u.length()-1);
            
            for(String str : u.split("")){
                if(str.equals("(") == true)
                    temp = temp.concat(")");
                else if(str.equals(")") == true)
                    temp = temp.concat("(");
            }
            
            //4-5
            return temp;
        }
        
    }
    static boolean check(String p){
        int len = p.length();
        int count = 0;
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i) == '(')
                count++;
            else if(p.charAt(i) ==')'){
                count--;
            }
            
            if(count < 0) return false;
        }
        
        return true;
        
    }
}