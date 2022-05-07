package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_15652 {
	static int N;
	static int M;
	static StringBuilder sb;
	static String[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		arr = new String[M];
		sb = new StringBuilder();
		
		dfs(0,1);
		System.out.println(sb.toString());
	}
	public static void dfs(int level, int startIdx) {
		if(level == M) {
			for(int i=0; i<M; i++)sb.append(arr[i]+" ");
			sb.append("\n");
			return;
		}
		
		for(int i=startIdx; i<=N; i++) {
			arr[level] = Integer.toString(i);
			dfs(level+1, i);
				
		}
	}
}
