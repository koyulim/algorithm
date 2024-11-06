import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        Map<String, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            map1.put(String.valueOf(i), str);
            map2.put(str, i);
        }

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if (map1.containsKey(str)) bw.write(map1.get(str) + "\n");
            else bw.write(map2.get(str) + "\n");
        }

        bw.flush();
    }
}
