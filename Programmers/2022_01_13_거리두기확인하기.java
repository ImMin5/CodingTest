//https://programmers.co.kr/learn/courses/30/lessons/81302

class Solution {
    public int[] solution(String[][] places) {
        int[] answer =  new int[places.length];
        for(int i=0; i<places.length; i++){
            String seats = "";
            for(String str : places[i]){
                seats = seats.concat(str);
            }
            if(checkValidate(seats) == true){
                answer[i] = 1;
            }
            else
                answer[i] = 0;
           
        }
        return answer;
    }
    private boolean checkValidate(String seats){
        int i,idx;
        
        for(idx = 0; idx<seats.length(); idx++){
            if(seats.charAt(idx) == 'P'){
                //좌
                if(idx%5 >= 2 ){
                    String temp = seats.substring(idx-2,idx);
                    if(temp.contains("P") && temp.equals("PX") == false)
                        return false;
                }
                //우
                if(idx%5 <= 2){
                  String temp = seats.substring(idx+1,idx+3);
                    if(temp.contains("P") && temp.equals("XP") == false ) 
                        return false;  
                } 
                //상
                if(idx>9){
                    String temp = "";
                    temp = temp.concat(Character.toString(seats.charAt(idx-5))+Character.toString(seats.charAt(idx-10)) ) ;
                        if(temp.contains("P") && temp.equals("XP") == false ) return false;
                }
                //하
                if(idx<15){
                    String temp = "";
                    temp = temp.concat(Character.toString(seats.charAt(idx+5)) +Character.toString(seats.charAt(idx+10)));
                    if(temp.contains("P") && temp.equals("XP") == false ) return false;
                }
            }
        }
     
        for(idx = 0, i=0; idx<19 ;idx++,i++){
            String temp = seats.substring(idx,idx+2).concat(seats.substring(idx+5,idx+7));
            
            if(temp.replaceAll("P","").length() <=2){
                if(temp.equals("PXXP") == false && temp.equals("XPPX") == false){
                    return false;
                }
            }
            if(i==3){
                i = -1;
                idx++;
            }
        }
        return true;
    }
}


// 더 좋은 다른사람들의 코드 , 프로그래머스 다른사람의 풀이를 통해 발견한 박건우,자코바님의 코드입니다.
/*

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visit;

    static int[] answer;

    public void dfs(int num, int x, int y, int count, String[] places){
        if (count > 2) return;
        if (count > 0 && count <= 2 && places[x].charAt(y) == 'P'){
            //2칸 범위내에 다른 응시자가 있을 경우 거리두기 미준수로 0처리
            answer[num] = 0;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            //배열 범위 밖으로 초과하는지 여부 검사, 파티션으로 분리되어 있는 경우 상관 없음.
            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && places[nx].charAt(ny) != 'X') {
                if (visit[nx][ny]) continue; //이미 방문한 곳일 경우 생략
                visit[nx][ny] = true;
                dfs(num, nx, ny, count + 1, places);
                visit[nx][ny] = false;
            }
        }
    }

    public int[] solution(String[][] places) {
        answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            answer[i] = 1;
        }

        for (int i = 0; i < places.length; i++) {
            visit = new boolean[5][5];
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (places[i][j].charAt(k) == 'P'){
                        visit[j][k] = true;
                        dfs(i, j, k, 0, places[i]);
                        visit[j][k] = false;
                    }
                }
            }
        }
        return answer;
    }
}


*/