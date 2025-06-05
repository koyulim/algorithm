import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] AB = br.readLine().split(" ");
        int A = Integer.parseInt(AB[0]);
        int B = Integer.parseInt(AB[1]);
        int C = Integer.parseInt(br.readLine());

        A = A + (B + C) / 60;
        B = (B + C) % 60;
        if (A >= 24) {
            A = A - 24;
        }

        bw.write(A + " " + B + "\n");
        bw.flush();
    }
}
