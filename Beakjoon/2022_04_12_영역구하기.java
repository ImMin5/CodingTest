//https://www.acmicpc.net/problem/2583

package boj;

import java.io.*;
import java.util.*;

public class Main_2583 {
    static boolean [][]visited;
    static int [][]map;
    static int []dx;
    static int []dy;
    static int N;
    static int M;
    static int sum;
    
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            //String path = System.getProperty("user.dir");
            //BufferedReader br = new BufferedReader(new FileReader(new File(path+"/src/boj/input.txt")));
            
            String []str = br.readLine().split(" ");
            
            M = Integer.parseInt(str[0]);
            N = Integer.parseInt(str[1]);
            int K = Integer.parseInt(str[2]);
            map = new int[M][N];
            visited = new boolean[M][N];
            dx = new int[]{0,0,-1, 1};
            dy = new int[]{1,-1,0, 0};
            ArrayList<Integer> answer = new ArrayList<Integer>();

            for(int i=0; i<K; i++){
                str = br.readLine().split(" ");
                int x1 = Integer.parseInt(str[0]);
                int y1 = Integer.parseInt(str[1]);
                int x2 = Integer.parseInt(str[2]);
                int y2 = Integer.parseInt(str[3]);
                for(int j = x1; j<x2; j++){
                    for(int k = y1; k<y2; k++){
                        map[k][j] = 1;
                    }
                }
            }
  
            for(int i=0; i<M; i++) {
                for(int j=0; j<N; j++) {
                    if(map[i][j] == 0 && visited[i][j] == false) {
                        sum = 1;    
                        calArea(j,i);
                        answer.add(sum);                
                    }
                }
            }
            Collections.sort(answer);
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<answer.size();i++) sb.append(answer.get(i)+" ");
           
            
            System.out.println(answer.size()+"\n"+sb.toString());

    }
    private static void calArea(int x, int y) {
        Queue<Location>q = new LinkedList<Location>();
        q.add(new Location(x,y));
        visited[y][x] = true;
        
        while(q.isEmpty() == false) {
            Location loc = q.poll();
            for(int i=0; i<4; i++) {
                int nx = loc.x+dx[i];
                int ny = loc.y+dy[i];
                if(nx<0||ny<0 || nx>=N || ny>=M)continue;
                if(map[ny][nx] == 0 && visited[ny][nx] == false) {
                    visited[ny][nx] = true;
                    sum++;
                    q.add(new Location(nx,ny));
                }
            }
        }
    }
}
class Location{
    int x;
    int y;
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
