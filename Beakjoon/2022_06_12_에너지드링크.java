//https://www.acmicpc.net/problem/20115

import java.io.*;


public class Main_20115 {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("./src/input.txt"));

        int N = Integer.parseInt(br.readLine());
        int[] drinks = new int[N];

        int idx = 0;
        int maxDrink = 0;
        double resultDrink = 0;

        for(String drink : br.readLine().split(" ")){
            drinks[idx] = Integer.parseInt(drink);
            maxDrink = Math.max(maxDrink,drinks[idx]);
            idx++;
        }


        for(int i=0; i<N; i++){
            if(maxDrink != drinks[i])
                resultDrink += (double)drinks[i]/2;
            else
                resultDrink += drinks[i];
        }

        System.out.println(resultDrink);
    }
}
