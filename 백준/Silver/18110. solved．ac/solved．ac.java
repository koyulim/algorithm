import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        float val = (float) (size * 0.15);
        int percent = Math.round(val);

        int[] list = new int[size];
        for (int i = 0; i < size; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(list);

        int total = 0;
        for (int i = percent; i < size - percent; i++) {
            total += list[i];
        }

        bw.write(Math.round((float) total / (size - (percent * 2))) + "\n");
        bw.flush();
    }
}
