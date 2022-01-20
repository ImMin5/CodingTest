//https://programmers.co.kr/learn/courses/30/lessons/92334

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        ArrayList<User> users = new ArrayList<>();
        HashMap<String,Integer> suspendedList = new HashMap<>(); //<이름,> Integer 값은 중요하지 않음 
        HashMap<String,Integer> idIdx = new HashMap<String,Integer>(); // <이름, 해당 이름의 User 클래스 idx>
        int idx = 0;

        //Id 별로 User 객체 생성
        for(String name : id_list) {
            idIdx.put(name,idx++);
            users.add(new User(name));
        }

        
        //신고
        for(String re : report){
            String[] str = re.split(" ");
            users.get( idIdx.get(str[0])).reportList.add(str[1]); 
            users.get( idIdx.get(str[1])).reportedList.add(str[0]);
        }
        
        //reportedList의 크기가 k번 이상이면 suspendedList에 추가됨
        for(User user : users){
            if(user.reportedList.size() >= k)
                suspendedList.put(user.name,1);
        }

        //reportList에 suspendedList가 있으면  answer 증가 
         for(User user : users){
             for(String nameReport : user.reportList){
                 if(suspendedList.get(nameReport) != null){
                     answer[idIdx.get(user.name)]++;
                 }

             }
        }
        return answer;
    }
}

class User{
    String name; // user 이름
    HashSet<String> reportList; //신고한 아이디
    HashSet<String> reportedList; // 누구에게 신고 당했는지 -> 중복신고를 걸러냄
    public User(String name){
        this.name = name;
        reportList = new HashSet<>();
        reportedList = new HashSet<>();
    }
}