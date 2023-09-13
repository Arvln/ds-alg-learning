package stack;

public class ParenthesesValidator {
    public static boolean isValid(String string) {
        ArrayListStack<Character> stack = new ArrayListStack<>(string.length());

        for (int i = 0; i < string.length(); i++) {
            char item = string.charAt(i);

            if (item == '(') stack.push(')');
            else if (item == '[') stack.push(']');
            else if (item == '{') stack.push('}');
            else {
                if (stack.isEmpty() || item != stack.pop()) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
