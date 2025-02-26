import java.awt.Point;
import java.beans.IntrospectionException;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = 10000;

        boolean[] list = new boolean[size + 1];
        int cnt = 1;
        while (cnt < size + 1) {
            int total = cnt;
            int a = cnt;
            while (a > 0) {
                total += a % 10;
                a = a / 10;
            }

            cnt ++;
            if (total <= size) {
                list[total] = true;
            }
        }

        for (int i = 1; i < list.length; i++) {
            if (!list[i]) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
    }
}
