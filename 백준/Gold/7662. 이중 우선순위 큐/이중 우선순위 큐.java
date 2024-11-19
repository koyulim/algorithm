import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            Queue<Integer> min = new PriorityQueue<>();
            Queue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int j = 0; j < k; j++) {
                String[] input = br.readLine().split(" ");
                String q = input[0];
                int n = Integer.parseInt(input[1]);

                if (q.equals("I")) {
                    min.add(n);
                    max.add(n);
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else {
                    if (!min.isEmpty() && !max.isEmpty()) {
                        if (n == 1) {
                            while (!max.isEmpty() && map.getOrDefault(max.peek(), 0) == 0) max.poll();
                            
                            if (!max.isEmpty()) {
                                int maxVal = max.poll();
                                map.put(maxVal, map.get(maxVal) - 1);
                                if (map.get(maxVal) == 0) {
                                    map.remove(maxVal);
                                }
                            }
                        } else {
                            while (!min.isEmpty() && map.getOrDefault(min.peek(), 0) == 0) min.poll();
                            
                            if (!min.isEmpty()) {
                                int minVal = min.poll();
                                map.put(minVal, map.get(minVal) - 1);
                                if (map.get(minVal) == 0) {
                                    map.remove(minVal);
                                }
                            }
                        }
                    }
                }
            }

            while (!min.isEmpty() && map.getOrDefault(min.peek(), 0) == 0) min.poll();
            while (!max.isEmpty() && map.getOrDefault(max.peek(), 0) == 0) max.poll();

            if (!min.isEmpty() && !max.isEmpty()) bw.write(max.peek() + " " + min.peek() + "\n");
            else bw.write("EMPTY" + "\n");
        }

        bw.flush();
    }
}

