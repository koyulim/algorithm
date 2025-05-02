import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.reverseOrder;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            List<Integer> arr = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                arr.add(Integer.parseInt(input[j]));
            }

            arr.sort(reverseOrder());
            bw.write(arr.get(2) + "\n");
            bw.flush();
        }
    }
}
