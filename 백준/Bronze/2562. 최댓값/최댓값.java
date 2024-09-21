import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer, Integer> map = new TreeMap<>();
        int idx = 1;
        int left = 0;

        while (true) {
            String n = br.readLine();
            if (n == null) {
                break;
            } else {
                map.put(Integer.parseInt(n), idx);
                idx++;
            }

            left = Math.max(left, Integer.parseInt(n));
        }

        bw.write(left + "\n");
        bw.write(map.get(left) + "\n");

        bw.flush();
    }
}