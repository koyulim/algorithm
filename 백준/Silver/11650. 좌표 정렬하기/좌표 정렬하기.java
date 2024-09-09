import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>(); 
        ArrayList<Integer> arr;

        for (int i = 0; i < size; i++) {
            String[] str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);

            arr = map.getOrDefault(x, new ArrayList<>());
            arr.add(y);
            map.put(x, arr);
        }

        for (int key : map.keySet()) {
            arr = new ArrayList<>();
            arr = map.get(key);
            Collections.sort(arr);
            for (int i = 0; i < arr.size(); i++) {
                bw.write(key + " " + arr.get(i) + "\n");
            }
        }

        bw.flush();
    }
}