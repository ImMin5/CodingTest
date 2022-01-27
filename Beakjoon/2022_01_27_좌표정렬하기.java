
//https://www.acmicpc.net/submit/11650/28119867

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		ArrayList<LOC> locations = new ArrayList<LOC>();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int x,y;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			locations.add(new LOC(x,y));
		}
		
		Comparator<LOC> comp = new MyCompare<LOC>();
		Collections.sort(locations,comp);
		
		for(LOC value : locations) {
			sb.append(value.getX()+" "+value.getY()).append('\n');
		}
		
		System.out.println(sb);
		br.close();
	

	}

}

class LOC {
	private int x;
	private int y;
	
	public LOC(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	public int getX() {return this.x;}
	public int getY() {return this.y;}
}

class MyCompare<T> implements Comparator<T>{

	@Override
	public int compare(T o1, T o2) {
		// TODO Auto-generated method stub
		LOC s1 = (LOC)o1;
		LOC s2 = (LOC)o2;
		
		if(s1.getX() > s2.getX()) return 1;
		else if(s1.getX() == s2.getX()) {
			if(s1.getY() > s2.getY()) return 1;
			else if(s1.getY() == s2.getY())return 0;
			else return -1;
		}
		else return -1;
	}
	
}