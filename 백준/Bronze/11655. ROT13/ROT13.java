import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            String str = input[i];
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) >= 'A' && str.charAt(j) <= 'Z') {
                    bw.write((char)((str.charAt(j) - 'A' + 13) % 26 + 'A'));
                } else if (str.charAt(j) >= 'a' && str.charAt(j) <= 'z') {
                    bw.write((char)((str.charAt(j) - 'a' + 13) % 26 + 'a'));
                } else {
                    bw.write(str.charAt(j));
                }
            }
            bw.write(" ");
        }
        bw.write("\n");
        bw.flush();
    }
}
