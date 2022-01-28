//https://www.acmicpc.net/problem/11725

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	public static void main(String []args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> [] list= new ArrayList[N+1];
		int []parents = new int[N+1];
		for(int i=0; i<=N; i++) list[i] = new ArrayList<Integer>();
		
		int a,b;
		for(int i=1; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		bfs(1,list,parents);
		
		StringBuilder sb = new StringBuilder();
		for(int i=2; i<=N; i++)sb.append(parents[i]+"\n");
		System.out.println(sb);
		
	}
	public static void bfs(int start, List<Integer> []list, int[] parents) {
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(start);
		parents[start] = 1;
		
		while(q.isEmpty() == false) {
			int parent = q.poll();
			
			for(int i=0; i<list[parent].size(); i++) {
				if(parents[list[parent].get(i)] == 0) {
					parents[list[parent].get(i)] = parent;
					q.add(list[parent].get(i));
				}
			}
		}
	}
}
