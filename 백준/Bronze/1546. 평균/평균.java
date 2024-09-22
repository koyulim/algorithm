import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] list = new int[size];
        for (int i = 0; i < size; i++) {
            list[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(list);

        int max = list[size - 1];
        float result = 0;
        for (int i = 0; i < size; i++) {
            result += (float)list[i] / max * 100;
        }

        bw.write(result/size + "\n");
        bw.flush();
    }
}