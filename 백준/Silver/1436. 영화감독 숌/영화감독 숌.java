import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int value = 666;
        int cnt = 0;
        while (true) {
            String str = String.valueOf(value);
            if (str.contains("666")) {
                cnt++;
            }
            
            if (cnt == n) {
                bw.write(value + "\n");
                break;
            }

            value++;
           
        }

        bw.flush();
    }
}
