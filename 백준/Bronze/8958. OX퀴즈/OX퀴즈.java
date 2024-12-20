import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            int result = 0;
            String input = br.readLine();
            int cnt = 0;
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == 'O') {
                    cnt++;
                    result += cnt;
                } else {
                    cnt = 0;
                }
            }
            bw.write(result + "\n");
        }
        bw.close();
    }
}
