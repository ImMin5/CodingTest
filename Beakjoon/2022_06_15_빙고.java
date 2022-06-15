//https://www.acmicpc.net/problem/2578

import java.io.*;


public class Main_2578 {
    public static void main(String[] args) throws IOException {
       Solution solution = new Solution();
    }

}

class Solution{
    public Solution() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("./src/input.txt"));
        int[] bingo = new int[25];
        int[] bingoLocation = new int[25];

        //빙고 초기화
        int idx = 0;
        for(int i=0; i<5; i++){
            String[] nums = br.readLine().split(" ");
            for(int j=0; j<5; j++){
                int num = Integer.parseInt(nums[j]) - 1;
                //숫자별 빙고 위치
                bingoLocation[num] = idx++;
            }
        }

        //사회자
        for(int i=0;i<5; i++){
            String[] nums = br.readLine().split(" ");
            for(int j=0; j<5; j++){
                int num = Integer.parseInt(nums[j]) - 1 ;
                int loc = bingoLocation[num];
                bingo[loc] = 1;
                //show(bingo, i*5+j+1);

                if((i*5+j+1)>=12 && checkBingo(bingo)) {
                    System.out.println((i * 5 + j + 1));
                    return;
                }
            }
        }
    }

    private void show(int[] bingo, int idx){
        System.out.println("\n-----------show-------"+ idx);
        for(int i=0; i<25; i++){
            if(i!=0 && i%5 == 0) System.out.println();
            System.out.print(bingo[i] + " ");

        }
    }
    private boolean checkBingo(int[] bingo){
        int countBingo = 0;
        //가로
        for(int i=0;i<5; i++){
            int countBingoRow = 0;
            for(int j=0; j<5; j++){
                if(bingo[i*5 + j] == 1)
                    countBingoRow++;
            }
            if(countBingoRow == 5) countBingo++;
        }
        //세로
        for(int i=0;i<5; i++){
            int countBingoCol = 0;
            for(int j=0; j<5; j++){
                if(bingo[j*5 + i] == 1)
                    countBingoCol++;
            }
            if(countBingoCol == 5) countBingo++;
        }
        //대각선
        int countBingoCross = 0;
        for(int i=0; i<5; i++){

            if(bingo[i*6] == 1)
                countBingoCross++;
        }
        if(countBingoCross == 5) countBingo++;

        countBingoCross = 0;
        for(int i=1; i<=5; i++){

            if(bingo[i*4] == 1)
                countBingoCross++;
        }
        if(countBingoCross == 5) countBingo++;

        //System.out.println("\nbingo : "+ countBingo);

        if(countBingo >= 3)
            return true;
        else
            return false;
    }

}

//12