//https://www.acmicpc.net/problem/9461


import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		long []dp = new long[101];
		
		dp[1]=1;
		dp[2]=1;
		dp[3]=1;
		dp[4]=2;
		dp[5]=2;

		for(int i=1; i<=T;i++) {
			int N = sc.nextInt();
			for(int j=6; j<=N; j++) {
				dp[j]=dp[j-1]+dp[j-5];
				//System.out.println(dp[j-1]+" "+ dp[j-4]);
			}
			System.out.println(dp[N]);
			
			
		}

	}

}