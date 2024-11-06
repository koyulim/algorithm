import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        Integer[] list = new Integer[n];

        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(list, Collections.reverseOrder());

        int cnt = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] > k) continue;
            cnt += k / list[i];
            k = k % list[i];
        }

        bw.write(cnt + "\n");
        bw.flush();
    }
}
