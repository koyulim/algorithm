import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int[] list = {1, 1, 2, 2, 2, 8};
        for (int i = 0; i < input.length; i++) {
            bw.write((list[i] - Integer.parseInt(input[i])) + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
