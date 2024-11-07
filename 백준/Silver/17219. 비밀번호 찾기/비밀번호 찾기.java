import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i ++) {
            String[] input = br.readLine().split(" ");
            map.put(input[0], input[1]);
        }

        for (int i = 0; i < m; i++) {
            String site = br.readLine();
            bw.write(map.get(site) + "\n");
        }
        
        bw.flush();
    }
}
