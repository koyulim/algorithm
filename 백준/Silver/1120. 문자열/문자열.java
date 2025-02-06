import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ab = br.readLine().split(" ");

        String a = ab[0];
        String b = ab[1];

        int alen = a.length();
        int blen = b.length();
        int result = Integer.MAX_VALUE;
        
        for (int i = 0; i <= blen - alen; i++) {
            int cnt = 0;
            for (int j = 0; j < alen; j++) {
                if (a.charAt(j) != b.charAt(i + j)) {
                    cnt++;
                }
            }
            result = Math.min(result, cnt);
        }

        bw.write(result + "\n");
        bw.flush();
    }
}
