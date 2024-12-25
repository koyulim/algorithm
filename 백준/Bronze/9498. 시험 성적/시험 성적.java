import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        if (90 <= n && n <= 100) {
            bw.write("A" + "\n");
        } else if (80 <= n && n <= 89) {
            bw.write("B" + "\n");
        } else if (70 <= n && n <= 79) {
            bw.write("C" + "\n");
        } else if (60 <= n && n <= 69) {
            bw.write("D" + "\n");
        } else {
            bw.write("F" + "\n");
        }
        
        bw.close();
    }
}
