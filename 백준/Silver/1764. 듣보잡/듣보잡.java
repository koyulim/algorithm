import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        TreeMap<String, Integer> map = new TreeMap<>();
        int cnt = 0;
        
        for (int i = 0; i < n + m; i++) {
            String name = br.readLine();
            if (map.containsKey(name)){
                cnt++;
                map.put(name, 1);
            }
            else map.put(name, 0);
        }

        bw.write(cnt + "\n");
        for (String key : map.keySet()) {
            if (map.get(key) == 1) bw.write(key + "\n");
        }

        bw.flush();
    }
}