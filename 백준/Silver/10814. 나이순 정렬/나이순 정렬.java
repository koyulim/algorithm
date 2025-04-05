import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());

        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            list.add(new String[]{input[0], input[1], String.valueOf(i)});
        }

        Collections.sort(list, (a, b) -> {
            int ageCompare = Integer.compare(Integer.parseInt(a[0]), Integer.parseInt(b[0]));
            if (ageCompare == 0) {
                return Integer.compare(Integer.parseInt(a[2]), Integer.parseInt(b[2]));
            }
            return ageCompare;
        });

        for (String[] person : list) {
            bw.write(person[0] + " " + person[1] + "\n");
        }
        bw.flush();
    }
}
