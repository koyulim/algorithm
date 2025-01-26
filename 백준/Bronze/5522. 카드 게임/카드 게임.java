import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int result = 0;

        for (int i = 0; i < 5; i++) {
            int value = Integer.parseInt(br.readLine());
            result += value;
        }
        bw.write(result + "\n");
        bw.flush();
    }
}