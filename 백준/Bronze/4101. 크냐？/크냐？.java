import java.io.*;
import java.util.*;

public class Main {
    
    static int cnt;
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String[] list = br.readLine().split(" ");
            int n = Integer.parseInt(list[0]);
            int m = Integer.parseInt(list[1]);
            if (n == 0 && m == 0) break;
            if (n > m) {
                bw.write("Yes" + "\n");
            } else {
                bw.write("No" + "\n");
            }
        }
        bw.flush();
    }
}
