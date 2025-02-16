import java.io.*;
import java.util.*;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        int[][] list = new int[size][2];
        
        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            list[i][0] = Integer.parseInt(input[0]);
            list[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(list[0][1]);
        for (int i = 1; i < size; i++) {
            int value = queue.peek();
            int start = list[i][0];
            int end = list[i][1];
            if (start < value) {
                queue.add(end);
            } else {
                queue.poll();
                queue.add(end);
            }
        }

        bw.write(queue.size() + "\n");
        bw.flush();
    }
}
