import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Stack<Character> stack;

        for (int i = 0; i < size; i++) {
            stack = new Stack<>();
            String input = sc.next();
            String result = "YES";
            for (int j = 0; j < input.length(); j++) {
                char ps = input.charAt(j);
                if (ps == '(')stack.add(ps);
                else {
                    if (!stack.empty() && stack.peek() == '(')stack.pop();
                    else {
                        result = "NO";
                        break;
                    }
                }
            }

            if (!stack.empty())result = "NO";
            System.out.println(result);
        }
    }
}