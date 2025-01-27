import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main {
    
    static int cnt;
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LocalDate now = LocalDate.now();
        bw.write(now + "\n");
        bw.flush();
    }
}
