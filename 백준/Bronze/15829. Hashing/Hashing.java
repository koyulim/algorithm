import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long value = 0;
        for (int i = 0; i < n; i++) {
            value += Math.pow(31, i) * ((int) str.charAt(i) - 96);
        }

        bw.write(value + "\n");
        bw.flush();
    }
}
