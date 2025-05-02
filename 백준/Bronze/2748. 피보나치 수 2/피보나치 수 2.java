import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());

        long[] list = new long[size + 1];
        list[0] = 0;
        list[1] = 1;
        for (int i = 2; i <= size; i++) {
            list[i] = list[i - 1] + list[i - 2];
        }
        bw.write(list[size] + "\n");
        bw.flush();
    }
}
