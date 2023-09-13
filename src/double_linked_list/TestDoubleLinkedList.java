package double_linked_list;

import org.junit.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TestDoubleLinkedList {
    @Test
    public void testAddFirst() {
        DoubleLinkedList list = new DoubleLinkedList();

        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        assertIterableEquals(Arrays.asList(1, 2, 3), list);
        assertEquals(3, list.size());
    }

    @Test
    public void testRemoveFirst() {
        DoubleLinkedList list = new DoubleLinkedList();

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
        DoubleLinkedList list = new DoubleLinkedList();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        assertIterableEquals(Arrays.asList(1, 2, 3), list);
        assertEquals(3, list.size());
    }

    @Test
    public void testRemoveLast() {
        DoubleLinkedList list = new DoubleLinkedList();

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
        DoubleLinkedList list = new DoubleLinkedList();

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
        DoubleLinkedList list = new DoubleLinkedList();

        assertThrows(IllegalArgumentException.class, () -> list.insert(1, 1));

        list.insert(0, 3);
        list.insert(0, 1);
        list.insert(1, 2);

        assertIterableEquals(Arrays.asList(1, 2, 3), list);
        assertEquals(3, list.size());
    }

    @Test
    public void testRemove() {
        DoubleLinkedList list = new DoubleLinkedList();

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
        DoubleLinkedList list = new DoubleLinkedList();

        int expected = 0;

        list.addFirst(2);
        list.addFirst(1);
        list.addFirst(0);

        for(int actual: list){
            assertEquals(expected, actual);
            expected = expected + 1;
        }
    }
}
