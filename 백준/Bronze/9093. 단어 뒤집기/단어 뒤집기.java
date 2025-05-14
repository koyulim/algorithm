import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                String str = input[j];
                for (int z = str.length() - 1; z >= 0; z--) {
                    bw.write(str.charAt(z) + "");
                }
                bw.write(" ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
