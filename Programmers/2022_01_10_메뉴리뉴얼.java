import java.util.*;

class Solution {
    static ArrayList<HashMap<String,Integer>> courseMap;
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        String tempAnswer = new String();
        courseMap = new ArrayList<HashMap<String,Integer>>();
        
        
        for(int i=0; i<course.length; i++) courseMap.add(new HashMap<String,Integer>());
        
        for(String order : orders){
            order = sort(order);
            for(int i=0; i<course.length; i++){
                if(order.length() >= course[i]) {
                    boolean[] used = new boolean[order.length()];
                    makeOrder(order, used, new String(), 0,course[i], i);
                }
            }
        }
        
        for(int i=0; i<course.length; i++){
            ArrayList<Map.Entry<String,Integer>> list = new ArrayList<>(courseMap.get(i).entrySet());
            Collections.sort(list, (o1,o2)->  o2.getValue() - o1.getValue());
            
            int maxCount = 0;
            for(Map.Entry<String,Integer> ent : list){
                if(ent.getValue() <2) continue;
                else {
                     maxCount = Math.max(maxCount, ent.getValue());
                    if(maxCount == ent.getValue())
                        tempAnswer = tempAnswer.concat(ent.getKey() + " ");
                }
            }
        }
        
       answer = tempAnswer.split(" ");
       Arrays.sort(answer);
       
        return answer;
    }
    
    static void makeOrder(String order, boolean[] used, String newCourse ,int index, int level, int mapIdx){
        if(level == 0){
            courseMap.get(mapIdx).put(newCourse, courseMap.get(mapIdx).getOrDefault(newCourse,0)+1);
            return;
        }
        
        for(int i=index; i<order.length(); i++){
            if(used[i] == false){
                used[i] = true;
                makeOrder(order, used, newCourse.concat(String.valueOf(order.charAt(i))),i+1, level-1, mapIdx);
                used[i] = false;
            }
        }
    }
    
    static String sort(String str){
        char[] c = str.toCharArray();
        for(int i=0; i<c.length; i++){
            for(int j=i+1; j<c.length; j++){
                if(c[i] > c[j]){
                    char temp = c[j];
                    c[j] = c[i];
                    c[i] = temp;
                }
            }
        }
        return new String(c);
    }
}