import java.util.*;
import java.io.*;

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

        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int left = 0;

        for (int i = 0; i < size; i++) {
            int value = list[i];
            map.put(value, map.getOrDefault(value, 0) + 1);

            while (map.size() > 2) {
                int next = list[left];
                map.put(next, map.get(next) - 1);

                if (map.get(next) == 0) {
                    map.remove(next);
                }
                left++;
            }
            
            result = Math.max(result, i - left + 1);
        }

        bw.write(result + "\n");
        bw.flush();
    }
}
