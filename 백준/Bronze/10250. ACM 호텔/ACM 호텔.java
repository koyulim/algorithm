import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            int h = Integer.parseInt(input[0]);
            int w = Integer.parseInt(input[1]); 
            int n = Integer.parseInt(input[2]);
            int result = 0;
            if (n % h == 0) {
                result = (100 * h) + (n / h);
            } else {
                result = ((n % h) * 100) + ((n / h) + 1);
            }

            bw.write(result + "\n");
        }
        
        bw.close();
    }
}
