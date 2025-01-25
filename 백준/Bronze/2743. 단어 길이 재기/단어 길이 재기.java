import java.io.*;
import java.util.*;

public class Main {
    
    static int cnt;
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        bw.write(str.length() + "\n");
        bw.flush();
    }
}