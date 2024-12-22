import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        String str = "";
        for (int i = 1; i < input.length; i++) {
            if (Integer.parseInt(input[i]) - Integer.parseInt(input[i - 1]) == 1) {
                str = "ascending";
            } else if ((Integer.parseInt(input[i - 1]) - Integer.parseInt(input[i]) == 1)) {
                str = "descending";
            } else {
                str = "mixed";
                break;
            }
        }

        bw.write(str + "\n");
        bw.close();
    }
}
