//https://www.acmicpc.net/problem/9465
import java.io.*;

public class Main_9465 {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("./src/input.txt"));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][N + 1];
            int[][] dp  = new int[2][N + 1];
            for(int j=0; j<2; j++){
                String[] nums = br.readLine().split(" ");
                for(int k=1; k<=N; k++){
                    stickers[j][k] = Integer.parseInt(nums[k-1]);
                }
            }

            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            for(int idx = 2; idx<=N; idx++){
                dp[0][idx] = Math.max(dp[1][idx-2], dp[1][idx-1]) + stickers[0][idx];
                dp[1][idx] = Math.max(dp[0][idx-2], dp[0][idx-1]) + stickers[1][idx];
            }

            System.out.println(Math.max(dp[0][N], dp[1][N]));

        }

    }


}
