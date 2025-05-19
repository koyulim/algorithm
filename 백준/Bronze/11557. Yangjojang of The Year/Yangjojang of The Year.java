import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(br.readLine());
            Integer[][] list = new Integer[num][2];
            String[] key = new String[num];
            for (int j = 0; j < num; j++) {
                String[] input = br.readLine().split(" ");
                key[j] = input[0];
                list[j][0] = Integer.parseInt(input[1]);
                list[j][1] = j;
            }
            Arrays.sort(list, (a, b) -> b[0] - a[0]);
            bw.write(key[list[0][1]] + "\n");
        }
        bw.flush();
    }
}
