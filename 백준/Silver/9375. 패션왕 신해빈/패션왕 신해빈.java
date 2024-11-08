import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int size = Integer.parseInt(br.readLine());
            for (int j = 0; j < size; j++) {
                String[] input = br.readLine().split(" ");
                if (map.containsKey(input[1])) map.put(input[1], map.get(input[1]) + 1);
                else map.put(input[1], 1);
            }

            int cnt = 1;
            for (String str : map.keySet()) cnt *= (map.get(str) + 1);
            bw.write((cnt - 1) + "\n");
        }

        bw.flush();
    }
}
