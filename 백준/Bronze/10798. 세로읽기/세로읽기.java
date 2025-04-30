import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] words = new String[5];
        int maxLength = 0;

        for (int i = 0; i < 5; i++) {
            words[i] = br.readLine();
            maxLength = Math.max(maxLength, words[i].length());
        }

        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < 5; j++) {
                if (i < words[j].length()) {
                    bw.write(words[j].charAt(i));
                }
            }
        }

        bw.flush();
    }
}
