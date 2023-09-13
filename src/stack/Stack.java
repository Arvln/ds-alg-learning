package stack;

public interface Stack<T> {
    /**
     *
     * @param value will be push into top of stack
     * @return if push successfully return true, else return false
     */
    boolean push(T value);

    /**
     * Remove item from top of stack and return be removed item's value
     * @return be removed item's value, if stack is empty return null
     */
    T pop();

    /**
     * Return item's value from top of stack
     * @return item's value from top of stack, if stack is empty return null
     */
    T peek();

    /**
     * Check stack is empty or not
     * @return if stack is empty return true, else return false
     */
    boolean isEmpty();

    /**
     * Check stack is full or not
     * @return if stack is full return true, else return false
     */
    boolean isFull();
}
