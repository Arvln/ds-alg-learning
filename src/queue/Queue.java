package queue;

public interface Queue<T> {

    /**
     * insert value into tail
     * @param value be inserted
     * @return if insert successfully return true, else return false
     */
    boolean offer(T value);

    /**
     * get value from head and remove it
     * @return if there are at least one value in queue return head value and remove it,
     *         else return null
     */
    T poll();

    /**
     * get value from head
     * @return if there are at least one value in queue return head value, else return null
     */
    T peek();

    /**
     * check if queue is empty or not
     * @return if queue is empty return true, else return false
     */
    boolean isEmpty();

    /**
     * check if queue size reach capacity
     * * @return if queue is full return true, else return false
     */
    boolean isFull();
}
