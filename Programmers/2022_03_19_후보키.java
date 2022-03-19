//https://programmers.co.kr/learn/courses/30/lessons/42890
//다시 풀기 
import java.util.*;

class Solution {
    static boolean []visited;
    static boolean []visitedComb;
    static int answer;
    
    static ArrayList<HashSet<Integer>> candidateKey; 
    public int solution(String[][] relation) {
        answer = 0;
        visited = new boolean[relation[0].length];
        candidateKey = new ArrayList<>();
        int colSize = relation[0].length;
    
        //조합 구하기 
       for(int i=1; i<=colSize; i++){
           makeKeySet(relation,0, i);
       }
        
        return candidateKey.size();
    }
    
    private void makeKeySet(String[][] relation, int start, int level){
        if(level == 0){
            /* 조합 
            
            System.out.print("comb : ");
            for(int i=0; i<relation[0].length; i++){
                if(visited[i] == true){
                    System.out.print(i + " ");
                }
            }
            */
            
            //후보키인지 검사
            HashSet<Integer> keySet = new HashSet<Integer>();
            int row = relation.length;
            int col = relation[0].length;
            for(int i=0; i<col; i++){
                if(visited[i])keySet.add(i);
            }
            
            for(HashSet<Integer> key : candidateKey) {
				if(keySet.containsAll(key)) {
					//System.out.println("는 " + key + "를 포함합니다.");
					return;
				}
			}
            
            
            HashSet<String> hset = new HashSet<>();  
            for(int i=0; i<row; i++){
                String set ="";
                //row 별로 조합 생성
                for(int j=0; j<col; j++){
                    if(visited[j])set+=relation[i][j];
                }
                hset.add(set);
            }
            
            if(hset.size() == row){
                candidateKey.add(keySet);
                //System.out.print(" 후보키 입니다.\n");
            }
            else
                //System.out.println(" 후보키가 아닙니다.");
            
            return;
        }
        
        for(int i= start; i<relation[0].length; i++){
            visited[i] = true;
            makeKeySet(relation, i+1, level-1);
            visited[i] = false;
        }
    }
    
    
}