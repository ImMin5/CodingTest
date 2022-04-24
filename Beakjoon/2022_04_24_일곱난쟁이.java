//https://www.acmicpc.net/problem/2309

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2309 {
    static boolean checked[];
    static int[] dwarves;
    static boolean answer_flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dwarves = new int[9];// 9명의 난쟁이
        checked = new boolean[9];

        for(int i=0; i<9; i++){
            dwarves[i] = Integer.parseInt(br.readLine());
            System.out.println(dwarves[i]);
        }
        Arrays.sort(dwarves);
        Main_2309 main = new Main_2309();
        main.solution();
    }

    public void solution() {
        calHeight(0,0);
    }
    private void calHeight(int level, int sum){
        if(level ==7 && sum == 100){
            if(answer_flag) return;
            for (int i = 0; i < checked.length; i++) {
                    if (checked[i]) System.out.println(dwarves[i]);
                    answer_flag = true;
            }
            return;
        }

        for(int i=0;i<9; i++){
            if(!checked[i]) {
                checked[i] = true;
                calHeight(level+1,sum+dwarves[i]);
                checked[i] = false;
            }
        }

    }
}




