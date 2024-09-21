import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] list = new int[1000001];
        int x = Integer.parseInt(br.readLine());

        list[2] = 1;
        list[3] = 1;

        for (int i = 4; i < 1000001; i++) {
            int a = 0; 
            int b = 0;
            int c = 0;
            int d = 0;

            if ((i % 2) == 0)a = 1 + list[i / 2];
            if ((i % 3) == 0)b = 1 + list[i / 3];
            c = 1 + list[i - 1];

            if (a != 0 && b != 0) {
                list[i] = Math.min(a, b);
            } else if (b != 0 && c != 0) {
                list[i] = Math.min(b, c);
            } else if (c !=0 && a != 0) {
                list[i] = Math.min(c, a);
            } else if (a != 0 && b != 0 && c !=0) {
                d = Math.min(a, b);
                list[i] = Math.min(d, c);
            } else {
                d = Math.max(a, b);
                list[i] = Math.max(d, c);
            }
        }

        bw.write(list[x] + "\n");
        bw.flush();
    }
}