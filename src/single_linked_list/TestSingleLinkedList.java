package single_linked_list;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSingleLinkedList {
    @Test
    public void testAddFirst() {
        SingleLinkedList list = new SingleLinkedList();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        list.loop1(System.out::println);
    }

    @Test
    public void testAddLast() {
        SingleLinkedList list = new SingleLinkedList();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.loop2(System.out::println);
    }

    @Test
    public void testGet() {
        SingleLinkedList list = new SingleLinkedList();

        assertThrows(
                "add at least one element into list.",
                IllegalArgumentException.class,
                () -> list.get(0)
        );

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        assertEquals(2, list.get(1));

        assertThrows(
                "index 3 is not valid.",
                IllegalArgumentException.class,
                () -> list.get(3)
        );
    }

    @Test
    public void testInsert() {
        SingleLinkedList list = new SingleLinkedList();

        list.insert(0, 1);

        list.addLast(2);
        list.addLast(4);
        list.insert(2, 3);

        assertThrows(
                "index 4 is not valid.",
                IllegalArgumentException.class,
                () -> list.insert(5, 6)
        );

        list.loop3();
    }

    @Test
    public void testRemoveFirst() {
        SingleLinkedList list = new SingleLinkedList();

        assertThrows(
                "add at least one element into list.",
                IllegalArgumentException.class,
                list::removeFirst
        );

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list.removeFirst();

        list.loop3();
    }

    @Test
    public void testRemove() {
        SingleLinkedList list = new SingleLinkedList();

        assertThrows(
                "add at least one element into list.",
                IllegalArgumentException.class,
                () -> list.remove(0)
        );

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        list.remove(0);
        list.remove(1);

        assertThrows(
                "index 3 is not valid.",
                IllegalArgumentException.class,
                () -> list.remove(3)
        );

        list.loop3();
    }
}
