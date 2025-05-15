import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());

        String str = br.readLine();
        Character[] list = new Character[str.length()];
        for (int i = 0; i < str.length(); i++) {
            list[i] = str.charAt(i);
        }

        for (int i = 1; i < size; i++) {
            str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                if (list[j] != str.charAt(j)) {
                    list[j] = '?';
                }
            }
        }
        String result = "";
        for (int i = 0; i < list.length; i++) {
            result += list[i];
        }
        bw.write(result);
        bw.flush();
    }
}
