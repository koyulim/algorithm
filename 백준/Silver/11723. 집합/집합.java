import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            String commend = input[0];
            int value = 0;

            if (commend.equals("add")) {
                value = Integer.parseInt(input[1]);
                map.put(value, 0);

            } else if (commend.equals("remove")) {
                value = Integer.parseInt(input[1]);
                map.remove(value);

            } else if (commend.equals("check")) {
                value = Integer.parseInt(input[1]);
                if (map.containsKey(value)) bw.write("1" + "\n");
                else bw.write("0" + "\n"); 

            } else if (commend.equals("toggle")) {
                value = Integer.parseInt(input[1]);
                if (map.containsKey(value)) map.remove(value);
                else map.put(value, 0); 

            } else if (commend.equals("all")) {
                
                for (int j = 1; j <= 20; j++) {
                    map.put(j, 0);
                }

            } else if (commend.equals("empty")) {
                map.clear();
            }
        }
        bw.flush();
    }
}