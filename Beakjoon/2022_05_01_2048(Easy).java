//https://www.acmicpc.net/problem/12100

import java.io.*;
import java.util.*;

public class Main{
	static int N;
	static int maxNum;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for(int i=0; i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				maxNum = maxNum < num ? num : maxNum;
				map[i][j] = num;
			}
		}

		
		dfs(0, map);
		//moveMap(map,3);
		//moveMap(map,3);
		
		
		
		
		System.out.println(maxNum);
		
	
	}
//	static public void showMap(int[][] map) {
//		for(int i=0; i<N;i++) {
//			for(int j=0; j<N; j++) {
//				System.out.print(map[i][j]+ " ");
//			}
//			System.out.println();
//		}
//		System.out.println("=========");
//	}
	static public void dfs(int level, int[][] map) {
		if(level >= 5)return;
		
		for(int i=0; i<4;i++) {
			int [][]newMap = new int[N][N];
			for(int k=0; k<N; k++) newMap[k] = map[k].clone();
			dfs(level+1, moveMap(newMap,i));
		}
		
	}
	static public int[][] moveMap(int [][]map, int direction) {
		//move left
		//System.out.println("direction----> " + direction);
		if(direction == 0 && isMovable(direction, map) )
			moveMapLeft(map);
		else if(direction == 1 )
			moveMapRight(map);
		else if(direction == 2)
			moveMapUp(map);
		else if(direction == 3)
			moveMapDown(map);
		
		//showMap(map);
		return map;
	}//moveMap end
	
	public static void moveMapDown(int [][]map) {
		boolean [][]combined = new boolean[N][N];
		//N개의 줄에서 실
		for(int i=0; i<N;i++) {
			//i번째 줄에서 j원소
			for(int j=N-2;j>=0;j--) {
				if(map[j][i] != 0) {
					//가장 오른 있는 숫자의 위치를 찾는다.
					int idx = 0;
					for(idx=j+1;idx<N; idx++) {
						if(map[idx][i] != 0) break;
					}
					
					if(idx>=N)idx=N-1;
					
					if(map[idx][i] == 0) {
						map[idx][i] = map[j][i];
						if(idx != j)map[j][i] = 0;
						//System.out.println("#0 i  " + i +" j "+ j + "idx :" + idx);
						//showMap(map);
					}
					//1.합칠 수 있는 숫자인가?
					else if(map[j][i] == map[idx][i]) {
						//1-1 이미 합쳐진 숫자인가?
						if(!combined[idx][i]) {
							map[idx][i] *=2;
							map[j][i] = 0;
							combined[idx][i] = true;
							combined[j][i] = false;
							maxNum = maxNum < map[idx][i] ? map[idx][i] : maxNum;
						}
						else{ 
							//1-2자리 이동
							if(idx-1>=0) {
								map[idx-1][i] = map[j][i];
								if(idx-1 != j)map[j][i] = 0;
							}	
						}
						
					}
					else {
						//3. 합칠 수 없을 때 
						if(idx-1>=0) {
							map[idx-1][i] = map[j][i];
							if(idx-1 != j)map[j][i] = 0;
						}	
					}
					
				}
			}
			
		}
		
	}
	
	public static void moveMapUp(int [][]map) {
		boolean [][]combined = new boolean[N][N];
		//N개의 행에서 실행 
		for(int i=0; i<N;i++) {
			//i행에서 j원소
			for(int j=1;j<N;j++) {
				if(map[j][i] != 0) {
					//가장 가까운 숫자의 위치를 찾는다.
					int idx = 0;
					for(idx=j-1;idx>=0; idx--) {
						if(map[idx][i] != 0) break;
					}
					if(idx<0)idx=0;
					
					if(map[idx][i] == 0) {
						map[idx][i] = map[j][i];
						if(idx != j)map[j][i] = 0;
						//System.out.println("#0 i  " + i +" j "+ j + "idx :" + idx);
						//showMap(map);
					}
					//1.합칠 수 있는 숫자인가?
					else if(map[j][i] == map[idx][i]) {
						//1-1 이미 합쳐진 숫자인가?
						if(!combined[idx][i]) {
							map[idx][i] *=2;
							map[j][i] = 0;
							combined[idx][i] = true;
							combined[j][i] = false;
							maxNum = maxNum < map[idx][i] ? map[idx][i] : maxNum;
						}
						else{ 
							//1-2자리 이
							if(idx+1<N) {
								map[idx+1][i] = map[j][i];
								if(idx+1 != j)map[j][i] = 0;
							}	
						}
						
					}
					else {
						//3. 합칠 수 없을 때 
						if(idx+1<N) {
							map[idx+1][i] = map[j][i];
							if(idx+1 != j)map[j][i] = 0;
						}	
					}
					
				}
			}
			
		}
		
	}
	
	public static void moveMapRight(int [][]map) {
		boolean [][]combined = new boolean[N][N];
		//N개의 줄에서 실
		for(int i=0; i<N;i++) {
			//i번째 줄에서 j원소
			for(int j=N-2;j>=0;j--) {
				//System.out.println("j---> "+ j);
				if(map[i][j] != 0) {
					//가장 오른 있는 숫자의 위치를 찾는다.
					int idx = N-2;
					for(idx=j+1;idx<N; idx++) {
						if(map[i][idx] != 0) break;
					}
					if(idx>=N)idx=N-1;
					if(map[i][idx] == 0) {
						map[i][idx] = map[i][j];
						if(idx != j)map[i][j] = 0;
						//System.out.println("#0 i  " + i +" j "+ j + "idx :" + idx);
						//showMap(map);
					}
					//1.합칠 수 있는 숫자인가?
					else if(map[i][j] == map[i][idx]) {
						//1-1 이미 합쳐진 숫자인가?
						if(!combined[i][idx]) {
							map[i][idx] *=2;
							map[i][j] = 0;
							combined[i][idx] = true;
							combined[i][j] = false;
							maxNum = maxNum < map[i][idx] ? map[i][idx] : maxNum;
							//System.out.println("#1 i  " + i +" j "+ j + "idx :" + idx);
							//showMap(map);
						}
						else{ 
							//1-2자리 이동
							if(idx-1>=0) {
								map[i][idx-1] = map[i][j];
								if(idx-1 != j)map[i][j] = 0;
								//System.out.println("#2 i  " + i +" j "+ j + "idx :" + idx);
								//showMap(map);
							}	
						}
						
					}
					else {
						//3. 합칠 수 없을 때 
						if(idx-1>=0) {
							map[i][idx-1] = map[i][j];
							if(idx-1 != j)map[i][j] = 0;
							//System.out.println("#3 i  " + i +" j "+ j + "idx :" + idx);
							//showMap(map);
						}	
					}
					
				}
			}
			
		}
	}
		
	static public void moveMapLeft(int [][]map) {
		boolean [][]combined = new boolean[N][N];
		//N개의 줄에서 실
		for(int i=0; i<N;i++) {
			//i번째 줄에서 j원소
			for(int j=1;j<N;j++) {
				if(map[i][j] != 0) {
					//가장 가까운 숫자의 위치를 찾는다.
					int idx = 0;
					for(idx=j-1;idx>=0; idx--) {
						if(map[i][idx] != 0) break;
					}
					//1.합칠 수 있는 숫자인가?
					
					if(idx<0)idx=0;
					if(map[i][idx] == 0) {
						map[i][idx] = map[i][j];
						if(idx != j)map[i][j] = 0;
						//System.out.println("#0 i  " + i +" j "+ j + "idx :" + idx);
						//showMap(map);
					}
					
					if(map[i][j] == map[i][idx]) {
						//1-1 이미 합쳐진 숫자인가?
						if(!combined[i][idx]) {
							//System.out.println("#1 i  " + i +" j "+ j + "idx :" + idx);
							
							map[i][idx] *=2;
							map[i][j] = 0;
							combined[i][idx] = true;
							combined[i][j] = false;
							maxNum = maxNum < map[i][idx] ? map[i][idx] : maxNum;
						//	showMap(map);
						}
						else{ 
							//1-2자리 이
							if(idx+1<N) {
								//System.out.println("#2 i  " + i +" j "+ j + "idx :" + idx);
								map[i][idx+1] = map[i][j];
								if(idx+1 != j)map[i][j] = 0;
								//showMap(map);
							}	
						}
						
					}
					else {
						//3. 합칠 수 없을 때 
						if(idx+1<N) {
							//System.out.println("#3 i  " + i +" j "+ j + "idx :" + idx);
							map[i][idx+1] = map[i][j];
							if(idx+1 != j)map[i][j] = 0;
							//showMap(map);
						}	
					}
					
				}
			}
			
		}
	}

}
