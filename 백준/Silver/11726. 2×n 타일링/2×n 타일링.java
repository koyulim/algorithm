import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[1001];
        list[1] = 1;
        list[2] = 2;

        for (int i = 3; i < 1001; i++) {
            list[i] = (list[i - 1] + list[i - 2]) % 10007;
        }

        bw.write(list[n] + "\n");
        bw.flush();
    }
}