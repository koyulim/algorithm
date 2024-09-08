import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        String[] nArr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            map.put(Integer.parseInt(nArr[i]), 0);
        }

        int m = Integer.parseInt(br.readLine());
        String[] mArr = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int chek = Integer.parseInt(mArr[i]);
            if (map.containsKey(chek))bw.write("1" + "\n");
            else bw.write("0" + "\n");
        }
        
        bw.flush();
    }
}