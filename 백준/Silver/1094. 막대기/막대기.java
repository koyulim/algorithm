import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());
        int n = 64;
        int cnt = 0;
        int sum = 0;
        if (x == 64) {
            cnt = 1;
        } else {
            while (sum < x) {
                n /= 2;
                if (sum + n <= x) {
                    sum += +n;
                    cnt++;
                }
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
    }
}
