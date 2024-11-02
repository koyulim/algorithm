import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        int[] list = new int[size];
        for (int i = 0; i < size; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);

        for (int i = 0; i < size; i++) {
            bw.write(list[i] + "\n");
        }

        bw.flush();
    }
}
