//https://programmers.co.kr/learn/courses/30/lessons/64065

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        ArrayList<Tuple> tuples = new ArrayList<>();
        s = s.substring(1,s.length()-1);
        
        
        //튜플의 문자열 정리 
        for(String str : s.split("}")){
            if(str.charAt(0) == ',') str = str.replaceFirst(",","");
            str = str.replace("{","");
            tuples.add(new Tuple(str));
        }
        
        // 집합의 원소 갯수가 작은것부터 정렬
        Collections.sort(tuples, new Comparator<Tuple>(){
           @Override
            public int compare(Tuple t1, Tuple t2){
                if(t1.size > t2.size) return 1;
                else
                    return -1;
            }
        });
        
        List<String> list = new ArrayList<String>();
        
        //튜플의 모든 원소를 순서대로 list에 삽입
        for(Tuple tp : tuples){
            for(int i=0; i<tp.size; i++){
                list.add(tp.t[i]);
            }
        }
        
        // 중복제거
        list = list.stream().distinct().collect(Collectors.toList());
        
        //정답입력
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = Integer.parseInt(list.get(i));
        }
        return answer;
    }
}

class Tuple{
    String []t;
    int size;
    public Tuple(String str){
        this.t = str.split(",");
        this.size = t.length;
    }
}