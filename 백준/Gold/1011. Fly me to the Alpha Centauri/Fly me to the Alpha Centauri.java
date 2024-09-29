import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");

            int n = Integer.parseInt(input[0]); 
            int m = Integer.parseInt(input[1]);

            int sqrt = (int)Math.sqrt(m - n);            
            int r = (m - n) - sqrt * sqrt;
            int leng = (sqrt * 2) - 1;   
            int result = 0;

            if (r == 0)result = leng;
            else if (r > 0 && r <= sqrt)result = leng + 1;
            else if (r > sqrt)result = leng + 2;
            else result = -1;

            bw.write(result + "\n");
        }
        
        bw. flush();
    }
}
