import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            map.put(Integer.parseInt(input[i]), map.getOrDefault(Integer.parseInt(input[i]), 0) + 1);
        }

        int value = Integer.parseInt(br.readLine());
        if (map.containsKey(value)) {
            bw.write(map.get(value) + "\n");
        } else {
            bw.write("0" + "\n");
        }
        bw.flush();
    }
}