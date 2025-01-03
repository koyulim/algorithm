import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int a = n / 10;
        int b = n % 10;
        int total = (b * 10) + ((a + b) % 10);
        int cnt = 1;
        while (true) {
            if (total == n) {
                break;
            } else {
                a = total / 10;
                b = total % 10;
                total = (b * 10) + ((a + b) % 10);
                cnt++;
            }
        }

        bw.write(cnt + "\n");
        bw.close();
    }
}
