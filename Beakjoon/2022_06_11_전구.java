import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_21918 {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("./src/input.txt"));
        String[] str  = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int[] bulbs = new int[N+1];

        int i = 1;
        for(String bulb : br.readLine().split(" ")){
            bulbs[i++] = Integer.parseInt(bulb);
        }

        for(i=0; i<M; i++){
            String[] cmds = br.readLine().split(" ");
            int a = Integer.parseInt(cmds[0]);
            int b = Integer.parseInt(cmds[1]);
            int c = Integer.parseInt(cmds[2]);

            if(a == 1){
                bulbs[b] = c;
            }
            else if(a == 2) {
                for(int j=b; j<=c; j++)
                    bulbs[j] = bulbs[j] == 0 ? 1 : 0;
            }
            else if(a == 3)
                Arrays.fill(bulbs,b,c+1,0);
            else if(a==4)
                Arrays.fill(bulbs,b,c+1, 1);
        }


        for(i=1; i<bulbs.length; i++)
            sb.append(bulbs[i]).append(" ");
        System.out.print(sb);

    }
}
