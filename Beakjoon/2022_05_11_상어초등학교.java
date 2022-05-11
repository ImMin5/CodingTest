//https://www.acmicpc.net/problem/21608

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Student []students;
	static int [][] room;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		/*
		File file = new File("./src/boj/input.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int []order = new int[N*N + 1];
		room = new int[N+1][N+1];
		students = new Student[(N*N) +1];
		int result = 0;
		
		for(int i=1; i<=N*N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			students[num] = new Student(st);
			order[i] = num;
		}
		
		for(int i=1; i<=N*N; i++) {
			role(order[i]);
			//output();
		}
		for(int i=1; i<=N*N; i++) {
			
			int count = checkAdjLike(students[i].getR(),students[i].getC(),students[i].getAdj());
			
			if(count == 1) result +=1;
			else if(count == 2) result +=10;
			else if(count == 3) result +=100;
			else if(count == 4) result += 1000;
		}
		
		System.out.println(result);
	}
	static void output() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				System.out.print(room[i][j]+ " ");
			}
			System.out.println();
		}
	}
	static int role(int num) {
		//좋아하는 학생의 번호를 가져온다.
		
		//System.out.println("role :"+ num);
		int []adj = students[num].getAdj();
		ArrayList<Location> location = new ArrayList<Location>();
		for(int i=1; i<=4; i++) {
			//좋아하는 학생이 앉아 있을 경우
			if(students[adj[i]].getSeated() == true) {
				//System.out.println("seated True : "+ adj[i]);
				int r = students[adj[i]].getR();
				int c = students[adj[i]].getC();
				
				if(r-1>=1 && room[r-1][c] == 0) location.add(new Location(r-1,c,checkAdjLike(r-1,c,adj),checkAdj(r-1,c)));
				if(r+1<=N && room[r+1][c] == 0) location.add(new Location(r+1,c,checkAdjLike(r+1,c,adj),checkAdj(r+1,c)));
				if(c-1>=1 && room[r][c-1] == 0) location.add(new Location(r,c-1,checkAdjLike(r,c-1,adj),checkAdj(r,c-1)));
				if(c+1<=N && room[r][c+1] == 0) location.add(new Location(r,c+1,checkAdjLike(r,c+1,adj),checkAdj(r,c+1)));

				
			}
		}
	//	System.out.println("location size :"+ location.size());

		MyComparator comp = new MyComparator();
		if(location.isEmpty() == true) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(room[i][j] == 0) {
						int adjCount = checkAdj(i,j);
						//System.out.println("r : "+i +" c : "+j+" ajdCount :"+ adjCount);
						location.add(new Location(i,j,0,adjCount));
					}
					
				}
			}
			
		}
		// 인접한 수가 많고 r,c 가 적은 순으로 정렬
		Collections.sort(location,comp);
		
		for(int i =0; i<location.size(); i++) {
			int count = location.get(i).getAdjCount();
			int like = location.get(i).getAdjLike();
			int r = location.get(i).getR();
			int c = location.get(i).getC();
			//System.out.println("like : "+like+" count"+count+" r :"+r +" c :"+c);
			
		}
		
		Location loc = location.get(0);
		room[loc.getR()][loc.getC()] = num;
		students[num].setSeated();
		students[num].setLocaction(loc.getR(), loc.getC());
		//System.out.println("num : " + num +" r : "+ loc.getR() + " c : "+ loc.getC());
		return 0;
	}

	static int checkAdj(int r, int c) {
		int count = 0;
		if(r-1>=1 && room[r-1][c] == 0)count++;
		if(r+1<=N && room[r+1][c] == 0)count++;
		if(c-1>=1 && room[r][c-1] == 0)count++;
		if(c+1<=N && room[r][c+1] == 0)count++;
		return count;
	}
	static int checkAdjLike(int r, int c, int[] adj) {
		int count = 0;
		if(r-1>=1 && room[r-1][c] != 0) {
			for(int i=1; i<=4; i++) {
				if(room[r-1][c] == adj[i]) {
					count++;
					//System.out.println("find :" + adj[i]);
					break;
				}
			}
		}
		if(r+1<=N && room[r+1][c] != 0) {
			for(int i=1; i<=4; i++) {
				if(room[r+1][c] == adj[i]) {
					count++;
					//System.out.println("find :" + adj[i]);
					break;
				}
			}
		}
		if(c-1>=1 && room[r][c-1] != 0) {
			for(int i=1; i<=4; i++) {
				if(room[r][c-1] == adj[i]) {
					count++;
					//System.out.println("find :" + adj[i]);
					break;
				}
			}
		}
		if(c+1<=N && room[r][c+1] != 0) {
			for(int i=1; i<=4; i++) {
				if(room[r][c+1] == adj[i]) {
					count++;
					//System.out.println("find :" + adj[i]);
					break;
				}
			}
		}
		
		return count;
		
	}
	static class Student{
		int []adj;
		Location loc;
		boolean seated;
		public Student() {}
		public Student(StringTokenizer st) {
			this.seated = false;
			this.adj = new int[5];
			for(int i=1; i<=4; i++) {
				adj[i] = Integer.parseInt(st.nextToken());
			}
		}
		
		public void setLocaction(int r, int c) { this.loc = new Location(r,c);}
		public void setSeated() {this.seated = true;}
		public boolean getSeated() {return this.seated;}
		public int getR() {return this.loc.getR();}
		public int getC() {return this.loc.getC();}
		public int[] getAdj() {return this.adj;}
		
		
	}
	
	static class Location{
		int r;
		int c;
		int adjCount;
		int adjLike;
		
		public Location(int r,int c) {
			this.r = r;
			this.c = c;
		}
		public Location(int r,int c,int adjLike, int adjCount) {
			this.r = r;
			this.c = c;
			this.adjCount = adjCount;
			this.adjLike = adjLike;
		}
		
		public int getR() {return this.r;}
		public int getC() {return this.c;}
		public void setAdjCount(int adjCount) {this.adjCount = adjCount;}
		public int getAdjCount() {return this.adjCount;}
		public int getAdjLike() {return this.adjLike;}

	}
	//규칙 2,3 을 위한 함수
	static class MyComparator implements Comparator<Location>{

		@Override
		public int compare(Location o1, Location o2) {
			if(o1.getAdjLike() < o2.getAdjLike()) return 1;
			else if(o1.getAdjLike() == o2.getAdjLike() ){
				if(o1.getAdjCount() < o2.getAdjCount()) return 1;
				else if(o1.getAdjCount() == o2.getAdjCount()){
					if(o1.getR() > o2.getR()) return 1;
					else if(o1.getR() == o2.getR()) {
						if(o1.getC() > o2.getC()) return 1;
					}
					
				}
			}
			return -1;
	
			
			// TODO Auto-generated method stub
			
		}
		
	}
	

}
//구현 넘나 힘든거...
