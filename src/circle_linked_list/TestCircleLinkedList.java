package circle_linked_list;

import org.junit.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TestCircleLinkedList {
    @Test
    public void testAddFirst() {
        CircleLinkedList list = new CircleLinkedList();

        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        assertIterableEquals(Arrays.asList(1, 2, 3), list);
        assertEquals(3, list.size());
    }

    @Test
    public void testRemoveFirst() {
        CircleLinkedList list = new CircleLinkedList();

        assertThrows(IndexOutOfBoundsException.class, list::removeFirst);

        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.removeFirst();

        assertIterableEquals(Arrays.asList(2, 3), list);
        assertEquals(2, list.size());
    }

    @Test
    public void testAddLast() {
        CircleLinkedList list = new CircleLinkedList();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        assertIterableEquals(Arrays.asList(1, 2, 3), list);
        assertEquals(3, list.size());
    }

    @Test
    public void testRemoveLast() {
        CircleLinkedList list = new CircleLinkedList();

        assertThrows(IndexOutOfBoundsException.class, list::removeLast);

        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.removeLast();

        assertIterableEquals(Arrays.asList(1, 2), list);
        assertEquals(2, list.size());
    }

    @Test
    public void testGet() {
        CircleLinkedList list = new CircleLinkedList();

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));

        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        assertEquals(1, list.get(0));
        assertEquals(3, list.size());
        assertThrows(IllegalArgumentException.class, () -> list.get(3));
        assertThrows(IllegalArgumentException.class, () -> list.get(-1));
    }

    @Test
    public void testInsert() {
        CircleLinkedList list = new CircleLinkedList();

        assertThrows(IllegalArgumentException.class, () -> list.insert(1, 1));

        list.insert(0, 3);
        list.insert(0, 1);
        list.insert(1, 2);

        assertIterableEquals(Arrays.asList(1, 2, 3), list);
        assertEquals(3, list.size());
    }

    @Test
    public void testRemove() {
        CircleLinkedList list = new CircleLinkedList();

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));

        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.remove(1);

        assertIterableEquals(Arrays.asList(1, 3), list);
        assertEquals(2, list.size());
    }

    @Test
    public void testIterator() {
        CircleLinkedList list = new CircleLinkedList();

        int expected = 0;

        list.addFirst(2);
        list.addFirst(1);
        list.addFirst(0);

        for(int actual: list){
            assertEquals(expected, actual);
            expected = expected + 1;
        }
    }

    @Test
    public void testRecursion() {
        CircleLinkedList actual = new CircleLinkedList();
        CircleLinkedList expected = new CircleLinkedList();

        actual.addFirst(2);
        actual.addFirst(1);
        actual.addFirst(0);
        actual.recursion(expected::addLast);

        assertIterableEquals(expected, actual);
    }
}
