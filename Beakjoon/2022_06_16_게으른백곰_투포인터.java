//https://www.acmicpc.net/problem/10025

import java.io.*;

public class Main_10025 {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("./src/input.txt"));

        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        int endIdx = 0;
        int startIdx = Integer.MAX_VALUE;
        int []location = new int[1000000];

        for(int i=0; i<N; i++){
            str = br.readLine().split(" ");
            int g = Integer.parseInt(str[0]);
            int x = Integer.parseInt(str[1]);
            startIdx = Math.min(startIdx, x);
            endIdx = Math.max(endIdx, x);
            location[x] = g;
        }

        int left = startIdx;
        int right = startIdx;
        int sum = 0;
        int maxSum = 0;

        //마지막 인덱스에 도달 할때 까지
        while(right <= endIdx){
            //right 피봇에 있는 얼음 값을 계속 더해줌
            sum += location[right];
            //부분합의 최댓값을 구해줌
            maxSum = Math.max(maxSum,sum);

            //백곰이 획득 할 수 있는 최대 거리 수에 도달 했을 경우
            //left값을 줄이고 sum에서 빼준다.
            if(right-left == K*2 + 1){
                sum -= location[left++];
            }
            right++;
        }

        System.out.println(maxSum);

    }
}
