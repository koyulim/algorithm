import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long s = Long.parseLong(br.readLine());
        long n = 0;
        long value = 0;
        while (true) {
            if (value > s - (n + 1)) {
                break;
            }
            n++;
            value += n;
        }
        
        bw.write(n + "\n");
        bw.flush();
    }
}
