import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] list = new int[size];
        int[] sortList = new int[size];

        for (int i = 0; i < size; i++) {
            list[i] = Integer.parseInt(input[i]);
            sortList[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(sortList);

        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;

        for (int val : sortList) {
            if (!map.containsKey(val)) {
                map.put(val, idx);
                idx++;
            }
        }
  
        for (int i = 0; i < size; i++) {
            bw.write(map.get(list[i]) + " ");
        }

        bw.flush();
    }
}
