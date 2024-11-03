import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Integer.parseInt(br.readLine());
        long result = 0;
        long start = 2;
        long end = 7;
        long level = 2;

        if (n == 1) {
            result = 1;
        } else {
            while (true) {
                if (start <= n && n <= end) {
                    result = level;
                    break;
                } else {
                    start = end + 1;
                    end += level * 6;
                    level++;
                }
            }
        }

        bw.write(result + "\n");
        bw.flush();
    }
}
