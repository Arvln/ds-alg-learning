package stack;

public class ExpressionCalculation {
    public static void pushCalculationResult(ArrayListStack<Integer> stack, String operation) {
        int prev1 = stack.pop();
        int prev2 = stack.pop();

        switch (operation){
            case "+":
                stack.push(prev2 + prev1);
                break;
            case "-":
                stack.push(prev2 - prev1);
                break;
            case "*":
                stack.push(prev2 * prev1);
                break;
            case "/":
                if (prev2 > 0) {
                    stack.push((int)Math.floor(prev2 / prev1));
                }
                break;
        }
    }

    public static int backCalculation(String[] calculation) {
        ArrayListStack<Integer> stack = new ArrayListStack<>(calculation.length);

        for (String item: calculation) {
            try {
                stack.push(Integer.parseInt(item));
            } catch (NumberFormatException e) {
                pushCalculationResult(stack, item);
            }
        }

        return stack.pop();
    }
}
