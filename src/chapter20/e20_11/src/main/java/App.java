import java.util.ArrayDeque;

public class App {
    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Usage: java App <str>");
        }
        System.out.println(areGroupingSymbolsInPairs(args[0]) ?
                                   "Grouping symbols are correct" :
                                   "Grouping symbols are incorrect");
    }

    public static boolean areGroupingSymbolsInPairs(String string) {
        var stack = new ArrayDeque<Character>();
        for (char ch: string.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    break;
                }
            } else if (ch == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    break;
                }
            } else if (ch == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    break;
                }
            }
        }
        return stack.isEmpty();
    }
}
