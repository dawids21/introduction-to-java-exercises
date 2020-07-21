import java.util.ArrayDeque;

public class InfixToPostfix {

    public static String convert(String expression) {
        if (expression == null) {
            throw new NullPointerException("Expression is null");
        }
        if (expression.length() == 0) {
            return "";
        }

        var operandStack = new ArrayDeque<String>();
        var operatorStack = new ArrayDeque<Character>();
        var normalizedExpression = normalizeExpression(expression);
        var tokens = normalizedExpression.split("\\s+");
        for (var token : tokens) {
            if (token.length() == 0) {
                continue;
            }
            if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                while (!operatorStack.isEmpty() && (operatorStack.peek() == '+' || operatorStack.peek() == '-' || operatorStack
                        .peek() == '*' || operatorStack.peek() == '/')) {
                    addOperation(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0));
            } else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
                while (!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
                    addOperation(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0));
            } else if (token.charAt(0) == '(') {
                operatorStack.push('(');
            } else if (token.charAt(0) == ')') {
                while (operatorStack.peek() != '(') {
                    addOperation(operandStack, operatorStack);
                }
                operatorStack.pop();
            } else {
                operandStack.push(token);
            }
        }
        while (!operatorStack.isEmpty()) {
            addOperation(operandStack, operatorStack);
        }
        return !operandStack.isEmpty() ? operandStack.pop() : "";

    }

    private static void addOperation(ArrayDeque<String> operandStack, ArrayDeque<Character> operatorStack) {
        char operator = operatorStack.pop();
        String operand2 = operandStack.pop();
        String operand1 = operandStack.pop();

        operandStack.push(operand1 + " " + operand2 + " " + operator);
    }

    private static String normalizeExpression(String expression) {
        var stringBuilder = new StringBuilder();
        for (char ch : expression.replaceAll("[^\\d+-/*)(]", "").toCharArray()) {
            if (ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '(' || ch == ')') {
                stringBuilder.append(" ").append(ch).append(" ");
            } else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }
}
