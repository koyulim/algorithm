import java.io.*;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char charValue = str.charAt(i);
            if (!map.containsKey(charValue)) {
                map.put(charValue, i);
            }
        }

        int n = 97;
        for (int i = 0; i < 26; i++) {
            char charValue = (char) n;
            if (map.containsKey(charValue)) {
                bw.write(map.get(charValue) + " ");
            } else {
                bw.write("-1" + " ");
            }
            n++;
        }
        bw.close();
    }
}
