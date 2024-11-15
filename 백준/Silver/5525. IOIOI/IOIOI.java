import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int cnt = 0;
        int paternCnt = 0;
        for (int i = 0; i < m - 1; i++) {
            if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'O' && i + 2 < m && s.charAt(i + 2) == 'I') {
                paternCnt++;
                if (paternCnt == n) {
                    cnt++;
                    paternCnt--;
                }
                i++;
            } else {
                paternCnt = 0;
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
    }
}
