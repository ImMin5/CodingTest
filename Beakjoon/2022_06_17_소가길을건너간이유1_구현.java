import java.io.*;
import java.util.HashMap;

public class Main_14467 {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("./src/input.txt"));
        HashMap<String,Integer> hmap = new HashMap<String, Integer>();

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        while( (N--) > 0){
            String[] info = br.readLine().split(" ");
            String cow = info[0];
            int status = info[1].charAt(0)-'0';
            int prevStatus = hmap.getOrDefault(cow, -1);

            hmap.put(cow, status);

            if(prevStatus != -1 && status != prevStatus)
                count++;
        }

        System.out.println(count);

    }
}
//배열 써도 됨
