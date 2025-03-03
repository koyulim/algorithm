import java.awt.Point;
import java.beans.IntrospectionException;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] list = new int[9];
        int total = 0;
        for (int i = 0; i < 9; i++) {
            list[i] = Integer.parseInt(br.readLine());
            total += list[i];
        }

        Arrays.sort(list);

        int x = 0;
        int y = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (total - list[i] - list[j] == 100) {
                    y = list[j];
                    x = list[i];
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (list[i] == x || list[i] == y) {
                continue;
            }
            bw.write(list[i] + "\n");
        }
        
        bw.flush();
    }
}
