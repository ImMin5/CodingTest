import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        ArrayList<String> set1 = new ArrayList<>();
        ArrayList<String> set2 = new ArrayList<>();
        
        makeSet(str1, set1);
        makeSet(str2, set2);
        
        if(set1.size() + set2.size() == 0) return 65536;
        
        Collections.sort(set1);
        Collections.sort(set2);
        
        answer = (int)(makeJ(set1,set2) * 65536);
        return answer;
    }
    
   
    private double makeJ(ArrayList<String> set1 , ArrayList<String> set2){
        int countUnion = 0;
        int countIntersection = 0;
        int idx = 0, len1, len2;
        
        len1 = set1.size();
        len2 = set2.size();
        
        for(int i=0; i<len1; i++){
            for(int j=idx; j<len2; j++){
                if(set1.get(i).equals(set2.get(j)) == true) {
                    countIntersection++;
                    idx = j+1;
                    break;
                }
            }
        }
        countUnion = set1.size() + set2.size() - countIntersection;
        return countIntersection/(double)countUnion;
    }
    
    private void makeSet(String str , ArrayList<String> set){
        int len = str.length();
        for(int i=0; i<len-1; i++){
            String temp = str.substring(i,i+2);
            if(temp.matches("^[a-zA-Z]*$")){
                temp = temp.toUpperCase();
                set.add(temp);
            }
        }
    }
}