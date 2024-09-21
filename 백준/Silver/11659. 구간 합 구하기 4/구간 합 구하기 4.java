import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] leng = br.readLine().split(" ");
        int n = Integer.parseInt(leng[0]);
        int m = Integer.parseInt(leng[1]);
        String[] list = br.readLine().split(" ");

        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(list[i - 1]);
        }
       
        for (int j = 0; j < m; j++) {
            String[] size = br.readLine().split(" ");
            int start = Integer.parseInt(size[0]);
            int end = Integer.parseInt(size[1]);
            bw.write((sum[end] - sum[start - 1]) + "\n");
        }

        bw.flush();
    }
}