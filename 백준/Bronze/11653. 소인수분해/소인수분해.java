import java.awt.Point;
import java.beans.IntrospectionException;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                bw.write(i + "\n");
                n /= i;
            }
        }

        if (n != 1) {
            bw.write(n + "\n");
        }

        bw.flush();
    }
}
